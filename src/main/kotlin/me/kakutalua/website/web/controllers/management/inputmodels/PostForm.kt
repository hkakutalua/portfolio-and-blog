package me.kakutalua.website.web.controllers.management.inputmodels

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class PostForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 30)
    val title: String = "",

    val subtitle: String?,

    @field:NotEmpty
    @field:Size(min = 20)
    val content: String = ""
)
