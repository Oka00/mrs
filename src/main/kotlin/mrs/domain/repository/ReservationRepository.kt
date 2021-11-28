package mrs.domain.repository


import mrs.domain.model.ReservableRoom
import mrs.domain.model.ReservableRoomId
import mrs.domain.model.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate


interface ReservationRepository : JpaRepository<Reservation, Int> {
//    fun findByReservableRoom_ReservableRoomId(reservableRoomId: ReservableRoomId?): List<Reservation>?
    fun findAllByReservableRoom(reservableRoom : ReservableRoom):List<Reservation>?
}