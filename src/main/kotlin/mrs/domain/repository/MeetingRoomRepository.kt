package mrs.domain.repository

import mrs.domain.model.MeetingRoom
import mrs.domain.model.Reservation
import org.springframework.data.jpa.repository.JpaRepository

interface MeetingRoomRepository : JpaRepository<MeetingRoom, Int> {
    fun findByRoomId(roomId: Int): MeetingRoom
}