package mrs.domain.model

import java.time.LocalTime
//import javax.persistence.Entity
//import javax.persistence.Id

//@Entity
class Reservation(
  //  @Id
    var reservationId: Int,
    var endTime: LocalTime,
    var startTime: LocalTime
)