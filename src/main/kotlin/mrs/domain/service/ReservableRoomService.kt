package mrs.domain.service

import mrs.domain.model.ReservableRoom
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import mrs.domain.repository.ReservableRoomRepository
import java.time.LocalDate

@Service
class reservableRoomService(val reservableRoomRepository: ReservableRoomRepository) {

    fun findAll(): MutableList<ReservableRoom> {
        return reservableRoomRepository.findAll()
    }

    fun findAllByReservedDate(reservedDate: LocalDate): List<ReservableRoom> {
        return reservableRoomRepository.findAllByReservedDate(reservedDate)
    }
}