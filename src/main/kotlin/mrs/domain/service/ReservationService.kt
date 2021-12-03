package mrs.domain.service

import mrs.domain.model.MeetingRoom
import mrs.domain.model.ReservableRoom
import mrs.domain.model.User
import mrs.domain.model.ReservableRoomId
import mrs.domain.model.Reservation
import mrs.domain.repository.MeetingRoomRepository
import mrs.domain.repository.ReservationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

@Service
class ReservationService(val reservationRepository: ReservationRepository,
                         val meetingRoomRepository: MeetingRoomRepository) {

    @Transactional
    fun reserveRoom(reservation: Reservation) {
        val allReservation = reservationRepository.findAll().filter { it?.reservableRoom?.roomId == reservation.reservableRoom.roomId}

        if (allReservation.isEmpty()) {
            reservationRepository.save(reservation)
        }
        else if(reservation.endTime <= reservation.startTime) {
            // TODO: 適切な例外処理
            throw Exception("予約エラー")
        } else if (reservation.startTime >= (allReservation.maxOf{ it.endTime }) ||
            reservation.endTime <= (allReservation.minOf{ it.startTime })) {
            reservationRepository.save(reservation)
        } else {
            // TODO: 適切な例外処理
            throw Exception("予約エラー")
        }
    }

    @Transactional(readOnly = true)
    fun reservationList(reservableRoom: ReservableRoom): List<Reservation>? {
        return reservationRepository.findAllByReservableRoom(reservableRoom)
    }

    @Transactional
    @PreAuthorize("#reservation.user.userId == principal.userId")
    fun removeReservation(reservation: Reservation) {
        return reservationRepository.delete(reservation)
    }

    @Transactional
    fun findByReservationId( reservationId: Int): Reservation {
        return reservationRepository.findByReservationId(reservationId)
    }
}
