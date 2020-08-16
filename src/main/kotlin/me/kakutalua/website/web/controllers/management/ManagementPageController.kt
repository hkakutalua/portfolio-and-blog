package me.kakutalua.website.web.controllers.management

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/management")
class ManagementPageController {
    @GetMapping
    fun index(): String {
        return "blog-posts-management"
    }
}