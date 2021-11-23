package mrs.domain.repository

import mrs.domain.model.ReservableRoom
import mrs.domain.model.ReservableRoomId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import mrs.domain.model.User

interface UserRepository: JpaRepository<User, String> {
    fun findByUserId(userId: String): User
}