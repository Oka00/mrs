package mrs.domain.repository

import mrs.domain.model.ReservableRoom
import mrs.domain.model.ReservableRoomId
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface ReservableRoomRepository: JpaRepository<ReservableRoom, ReservableRoomId>{
    fun findAllByReservedDate(reservedDate: LocalDate): List<ReservableRoom>
    fun findByReservedDateAndRoomId(reservedDate: LocalDate, roodId:Int): ReservableRoom
}