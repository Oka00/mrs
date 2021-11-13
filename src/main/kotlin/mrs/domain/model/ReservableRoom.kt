package mrs.domain.model

import java.time.LocalDate
import java.io.Serializable;
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

// Composite-id class must implement Serializable と Error
// 複合キーを持つクラスは Serializable	を implements　しなくてはいけない
class ReservableRoom (
    @Id
    private val reservedDate: LocalDate,
    @Id
    private val roomId: Int,
    @ManyToOne
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    private var MeetingRoom: MeetingRoom
) : Serializable