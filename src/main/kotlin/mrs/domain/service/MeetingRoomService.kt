package mrs.domain.service

import mrs.domain.model.MeetingRoom
import mrs.domain.repository.MeetingRoomRepository
import mrs.domain.repository.ReservationRepository
import org.springframework.stereotype.Service

@Service
class MeetingRoomService(val meetingRoomRepository: MeetingRoomRepository) {
    fun findByRoomId(roomId: Int): MeetingRoom {
        return meetingRoomRepository.findByRoomId(roomId)
    }
}