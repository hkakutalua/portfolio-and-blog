package me.kakutalua.website.web.controllers.viewmodels

import java.time.OffsetDateTime

data class LandingPageBlogPostViewModel(
    val id: Long,
    val title: String,
    val publishingDate: OffsetDateTime?
)