package me.kakutalua.website.infrastructure.security

import me.kakutalua.website.infrastructure.repositories.UsersRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserToAuthenticateRetriever(private val usersRepository: UsersRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = usersRepository.findByEmail(username.toLowerCase())
        if (user == null) {
            throw UsernameNotFoundException("User with username $username was not found!")
        }

        return User(user.email, user.passwordHash, listOf())
    }
}