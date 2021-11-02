package mrs.domain.model

import java.time.LocalTime
@Entity
class Reservation (
    private val reservationId: Int,
    private val endTime: LocalTime,
    private val startTime: LocalTime
)