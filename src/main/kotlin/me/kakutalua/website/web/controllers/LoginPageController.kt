package me.kakutalua.website.web.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping
class LoginPageController {
    @GetMapping("/login")
    fun get() = "login"
}