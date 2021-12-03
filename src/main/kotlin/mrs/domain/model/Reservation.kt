package mrs.domain.model

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
class Reservation(
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val reservationId: Int?,
    val endTime: LocalTime,
    val startTime: LocalTime,

    @ManyToOne
    @JoinColumns(
        JoinColumn(name = "reservedDate", referencedColumnName = "reservedDate"),
        JoinColumn(name = "roomId", referencedColumnName = "roomId")
    )
    val reservableRoom: ReservableRoom,

    @ManyToOne
    @JoinColumn(name="userId")
    val user: User

)