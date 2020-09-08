package me.kakutalua.website.web.controllers

import me.kakutalua.website.domain.BlogPost
import me.kakutalua.website.domain.BlogPost_
import me.kakutalua.website.domain.PublishingStatus
import me.kakutalua.website.infrastructure.repositories.BlogPostsRepository
import me.kakutalua.website.web.controllers.management.mappers.LandingPageBlogPostViewModelMapper
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.time.OffsetDateTime
import java.util.function.Function

@Controller
class LandingPageController(private val blogPostsRepository: BlogPostsRepository) {
    @GetMapping
    fun index(model: Model): String {
        val sortingByPublishingDateDescending = Sort
            .sort(BlogPost::class.java)
            .by(Function<BlogPost, OffsetDateTime?> { post -> post.publishingDate })
            .descending()

        val publishedSpecification = Specification<BlogPost> { root, _, builder ->
            builder.equal(root[BlogPost_.publishingStatus], PublishingStatus.PUBLISHED)
        }

        val blogPosts = blogPostsRepository.findAll(
            publishedSpecification,
            PageRequest.of(0, 3, sortingByPublishingDateDescending)
        )

        model["blogPosts"] = LandingPageBlogPostViewModelMapper.map(blogPosts.content)

        return "landing-page"
    }
}