package mrs.domain.model

import java.time.LocalDate

class ReservableRoom (
    private val reseservedDate: LocalDate,
    private val roomId: Int
)