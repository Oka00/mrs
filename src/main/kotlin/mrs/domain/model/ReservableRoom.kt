package mrs.domain.model

import java.time.LocalDate
import java.io.Serializable;
import javax.persistence.*

// Composite-id class must implement Serializable と Error
// 複合キーを持つクラスは Serializable	を implements　しなくてはいけない
//                     @IdClass(value=) でkeyClassを指定しなくてはいけない
@Entity
@IdClass(value=ReservableRoomId::class)
class ReservableRoom (
    @Id
    var reservedDate: LocalDate,
    @Id
    var roomId: Int,
    @ManyToOne
    @JoinColumn(name = "roomId", referencedColumnName = "roomId", insertable = false, updatable = false)
    var meetingRoom: MeetingRoom?
) : Serializable

@Entity
class ReservableRoomId (
    @Id
    private val reservedDate: LocalDate,
    @Id
    private val roomId: Int
    ) : Serializable