package me.kakutalua.website.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LandingPageController {
    @GetMapping
    fun index(model: Model): String {
        return "landing-page"
    }
}