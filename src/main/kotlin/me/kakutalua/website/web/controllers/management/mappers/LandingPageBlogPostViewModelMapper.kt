package me.kakutalua.website.web.controllers.management.mappers

import me.kakutalua.website.domain.BlogPost
import me.kakutalua.website.web.controllers.viewmodels.LandingPageBlogPostViewModel

class LandingPageBlogPostViewModelMapper {
    companion object {
        fun map(blogPost: BlogPost): LandingPageBlogPostViewModel {
            return LandingPageBlogPostViewModel(
                id = blogPost.id,
                title = blogPost.title,
                publishingDate = blogPost.publishingDate
            )
        }

        fun map(blogPosts: List<BlogPost>): List<LandingPageBlogPostViewModel> {
            return blogPosts.map { post -> map(post) }
        }
    }
}