package me.kakutalua.website.web.controllers.viewmodels

import java.time.OffsetDateTime

data class BlogPostViewModel(
    val title: String,
    val subtitle: String?,
    val content: String,
    val publishingDate: OffsetDateTime?
)