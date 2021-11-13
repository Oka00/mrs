package mrs.domain.model

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
class Reservation(
    @Id
    val reservationId: Int,
    val endTime: LocalTime,
    val startTime: LocalTime,

    @ManyToOne
    @JoinColumns(
        JoinColumn(name = "reservedDate"), JoinColumn(name = "roomId")
    )
    val reservableRoom: ReservableRoom,

    @ManyToOne
    @JoinColumn(name="userId")
    val user: User
)