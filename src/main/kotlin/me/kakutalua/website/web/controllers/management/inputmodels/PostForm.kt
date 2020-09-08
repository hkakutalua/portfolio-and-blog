package me.kakutalua.website.web.controllers.management.inputmodels

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size
import kotlin.math.min

class PostForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val title: String = "",

    @field:Size(min = 5, max = 100)
    val subtitle: String?,

    @field:NotEmpty
    @field:Size(min = 20)
    val content: String = ""
)
