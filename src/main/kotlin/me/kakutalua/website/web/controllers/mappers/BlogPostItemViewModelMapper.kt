package me.kakutalua.website.web.controllers.mappers

import me.kakutalua.website.domain.BlogPost
import me.kakutalua.website.web.controllers.viewmodels.BlogPostItemViewModel

class BlogPostItemViewModelMapper {
    companion object {
        fun map(blogPost: BlogPost): BlogPostItemViewModel {
            return BlogPostItemViewModel(
                id = blogPost.id,
                title = blogPost.title,
                subtitle = blogPost.subtitle,
                publishingDate = blogPost.publishingDate
            )
        }

        fun map(content: List<BlogPost>): List<BlogPostItemViewModel> {
            return content.map { post -> map(post) }
        }
    }
}