package mrs.app.room



import mrs.domain.service.ReservableRoomService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.view.RedirectView
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Controller
class RoomController(val reservedRoomService: ReservableRoomService) {

    @GetMapping("/reservableRoomList")
    fun list(model: Model): RedirectView{
        val today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        return RedirectView("reservableRoomList/${today}")
    }

    @GetMapping("/reservableRoomList/{date}")
    fun list(
        model: Model,
        @PathVariable
        @DateTimeFormat(pattern = "yyyyMMdd")
        date: LocalDate
    ): String{
        model["date"] = date
        model["roomList"] = reservedRoomService.findAllByReservedDate(date)
        return "reservableRoomList"
    }
}