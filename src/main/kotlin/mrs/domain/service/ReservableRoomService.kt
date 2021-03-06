package mrs.domain.service

import mrs.domain.model.ReservableRoom
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import mrs.domain.repository.ReservableRoomRepository
import org.springframework.security.core.annotation.AuthenticationPrincipal
import java.time.LocalDate

@Service
class ReservableRoomService(val reservableRoomRepository: ReservableRoomRepository) {

    fun findAll(): MutableList<ReservableRoom> {
        return reservableRoomRepository.findAll()
    }

    fun findAllByReservedDate(reservedDate: LocalDate): List<ReservableRoom> {
        return reservableRoomRepository.findAllByReservedDate(reservedDate)
    }

    fun findByReservedDateAndRoomId(reservedDate: LocalDate, roomId:Int): ReservableRoom {
        return reservableRoomRepository.findByReservedDateAndRoomId(reservedDate, roomId)
    }

}