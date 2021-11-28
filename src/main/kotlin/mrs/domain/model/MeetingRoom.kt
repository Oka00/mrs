package mrs.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.GenerationType

@Entity
class MeetingRoom (
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        val roomId: Int,
        val roomName: String
)