package me.kakutalua.website.web.controllers.viewmodels

import java.time.OffsetDateTime

data class BlogPostItemViewModel(
    val id: Long,
    val title: String,
    val subtitle: String?,
    val publishingDate: OffsetDateTime?
)