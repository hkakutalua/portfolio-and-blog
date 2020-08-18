package me.kakutalua.website.infrastructure.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration(
    private val userToAuthenticateRetriever: UserToAuthenticateRetriever
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http
            ?.authorizeRequests()
                ?.antMatchers("*")?.permitAll()
                ?.antMatchers("/management")?.authenticated()
                ?.and()
            ?.formLogin()
                ?.loginPage("/login")?.permitAll()
                ?.defaultSuccessUrl("/management/blog-posts")
                ?.and()
            ?.logout()
                ?.permitAll()
    }

    override fun userDetailsService() = userToAuthenticateRetriever

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}