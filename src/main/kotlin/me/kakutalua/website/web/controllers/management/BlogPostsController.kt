package me.kakutalua.website.web.controllers.management

import me.kakutalua.website.domain.BlogPost
import me.kakutalua.website.infrastructure.repositories.BlogPostsRepository
import me.kakutalua.website.web.controllers.management.inputmodels.PostForm
import me.kakutalua.website.web.controllers.management.viewmodels.BlogPostManagementItemViewModel
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import javax.validation.Valid

@Controller(value = "ManagementBlogPostsController")
@RequestMapping("/management/blog-posts")
class BlogPostsController(val blogPostsRepository: BlogPostsRepository) {
    @GetMapping
    fun index(pageable: Pageable, model: Model): String {
        val blogPosts = blogPostsRepository.findAll(pageable)
        val blogPostsItems = blogPosts.map { p ->
            BlogPostManagementItemViewModel(
                p.id,
                p.creationDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)),
                p.title
            )
        }

        model["blogPosts"] = blogPostsItems
        model["isFirstPage"] = blogPosts.isFirst
        model["isLastPage"] = blogPosts.isLast
        model["pageNumber"] = blogPosts.number

        return "blog-posts-management"
    }

    @GetMapping("new")
    fun new(@ModelAttribute("postForm") postForm: PostForm): String {
        return "new-blog-post"
    }

    @PostMapping
    fun postNew(
        @Valid @ModelAttribute("postForm")
        postForm: PostForm,
        bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            return "new-blog-post"
        }

        val blogPost = BlogPost(postForm.title, postForm.subtitle, postForm.content)
        blogPostsRepository.save(blogPost)

        return "redirect:/management/blog-posts"
    }

    @GetMapping("{id}/edit")
    fun edit(@PathVariable("id") id: Long, model: Model): String {
        val blogPost = blogPostsRepository.findByIdOrNull(id)
        if (blogPost == null) {
            return "redirect:/management/blog-posts"
        }

        model["postForm"] = PostForm(
            blogPost.title,
            blogPost.subtitle,
            blogPost.content,
            blogPost.publishingStatus
        )

        return "edit-blog-post"
    }

    @PostMapping("{id}/edit")
    fun edit(
        @PathVariable("id")
        id: Long,

        @Valid @ModelAttribute("postForm")
        postForm: PostForm
    ): String {
        val blogPost = blogPostsRepository.findByIdOrNull(id)
        if (blogPost == null) {
            return "redirect:/management/blog-posts"
        }

        blogPost.title = postForm.title
        blogPost.subtitle = postForm.subtitle
        blogPost.content = postForm.content
        blogPost.publishingStatus = postForm.publishingStatus
        blogPostsRepository.save(blogPost)

        return "redirect:/management/blog-posts"
    }
}