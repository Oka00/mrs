package mrs.app.reservation

import mrs.domain.model.ReservableRoom
import mrs.domain.model.Reservation
import mrs.domain.model.User
import mrs.domain.service.MeetingRoomService
import mrs.domain.service.ReservableRoomService
import mrs.domain.service.ReservationService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalTime


@Controller
@RequestMapping("/reservations/{date}/{roomId}")
class ReservationController(val reservationService: ReservationService,
                            val meetingRoomService: MeetingRoomService,
                            val reservableRoomService: ReservableRoomService) {
    @GetMapping
    fun reservePage(
        model: Model,
        @PathVariable
        @DateTimeFormat(pattern = "yyyyMMdd")
        date: LocalDate,
        @PathVariable
        roomId: Int
    ): String {
        val meetingRoom  = meetingRoomService.findByRoomId(roomId)
        val reservationList =  reservationService.reservationList(ReservableRoom(date, roomId, meetingRoom))
        if(reservationList !=null){
            model["reservationList"] = reservationList
        }
        model["date"] = date
        model["roomId"] = roomId
        model["roomName"] = meetingRoom.roomName
        return "reservations"
    }

    @RequestMapping(method = [RequestMethod.POST], params = ["delete"])
    fun deleteReservation(
        model: Model,
        @RequestParam
        reservationId: Int,
        @RequestParam
        @DateTimeFormat(pattern = "yyyyMMdd")
        date: LocalDate,
        @RequestParam
        roomId: Int
    ) : String{

        reservationService.removeReservation(reservationId)
        return "redirect:/reservations/{date}/{roomId}"

    }

    @RequestMapping(method = [RequestMethod.POST], params = ["save"])
    fun saveReservation(
        model: Model,
        @RequestParam
        startTime: LocalTime,
        @RequestParam
        endTime: LocalTime,
        @RequestParam
        @DateTimeFormat(pattern = "yyyyMMdd")
        date: LocalDate,
        @RequestParam
        roomId: Int,
        @AuthenticationPrincipal
        user: User
    ) :String {

        reservationService.reserveRoom(
            Reservation(null, endTime, startTime,
                ReservableRoom(date, roomId, null),
                user)
        )
        return "redirect:/reservations/{date}/{roomId}"
    }

}
