package me.kakutalua.website.infrastructure.repositories

import me.kakutalua.website.domain.User
import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<User, Long> {
    fun findByEmail(username: String): User?
}