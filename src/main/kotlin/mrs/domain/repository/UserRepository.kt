package mrs.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import mrs.domain.model.User

interface UserRepository: JpaRepository<User, String> {
    fun findByUserId(userId: String): User
}