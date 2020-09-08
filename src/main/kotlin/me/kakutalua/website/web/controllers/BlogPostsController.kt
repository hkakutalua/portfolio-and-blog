package me.kakutalua.website.web.controllers

import me.kakutalua.website.domain.BlogPost
import me.kakutalua.website.domain.BlogPost_
import me.kakutalua.website.domain.PublishingStatus
import me.kakutalua.website.infrastructure.repositories.BlogPostsRepository
import me.kakutalua.website.infrastructure.services.MarkdownToHtmlRenderer
import me.kakutalua.website.web.controllers.mappers.BlogPostItemViewModelMapper
import me.kakutalua.website.web.controllers.viewmodels.BlogPostViewModel
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/blog-posts")
class BlogPostsController(
    private val blogPostsRepository: BlogPostsRepository,
    private val markdownToHtmlRenderer: MarkdownToHtmlRenderer
) {
    @GetMapping
    fun index(model: Model, pageable: Pageable): String {
        val publishedSpecification = Specification<BlogPost> { root, _, builder ->
            builder.equal(root[BlogPost_.publishingStatus], PublishingStatus.PUBLISHED)
        }
        val blogPostsPage = blogPostsRepository.findAll(publishedSpecification, pageable)

        model["isFirstPage"] = blogPostsPage.isFirst
        model["isLastPage"] = blogPostsPage.isLast
        model["blogPosts"] = BlogPostItemViewModelMapper.map(blogPostsPage.content)
        model["pageNumber"] = blogPostsPage.number

        return "blog-posts"
    }

    @GetMapping("{id}")
    fun details(model: Model, @PathVariable("id") blogId: Long): String {
        val blogPost = blogPostsRepository.findByIdOrNull(blogId)
        if (blogPost == null || blogPost.publishingStatus != PublishingStatus.PUBLISHED) {
            return "redirect:blog-posts"
        }

        model["blogPost"] = BlogPostViewModel(
            title = blogPost.title,
            subtitle = blogPost.subtitle,
            content = markdownToHtmlRenderer.renderToHtml(blogPost.content),
            publishingDate = blogPost.publishingDate
        )

        return "blog-post"
    }
}