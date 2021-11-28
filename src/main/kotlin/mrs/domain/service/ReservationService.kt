package mrs.domain.service

import mrs.domain.model.MeetingRoom
import mrs.domain.model.ReservableRoom
import mrs.domain.model.ReservableRoomId
import mrs.domain.model.Reservation
import mrs.domain.repository.MeetingRoomRepository
import mrs.domain.repository.ReservationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class ReservationService(val reservationRepository: ReservationRepository,
                         val meetingRoomRepository: MeetingRoomRepository) {

    @Transactional
    fun reserveRoom(reservation: Reservation) {
        reservationRepository.save(reservation)
    }

    @Transactional(readOnly = true)
    fun reservationList(reservableRoom: ReservableRoom): List<Reservation>? {
        return reservationRepository.findAllByReservableRoom(reservableRoom)
    }

    @Transactional
    fun removeReservation(reservationId: Int) {
        return reservationRepository.deleteById(reservationId)
    }
}
