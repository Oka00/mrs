package mrs.domain.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class MeetingRoom (
        @Id
        private val roomId: Int,
        private val roomName: String
)