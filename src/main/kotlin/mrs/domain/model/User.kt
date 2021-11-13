package mrs.domain.model

import javax.persistence.*

@Entity
@Table(name="usr")
class User (
    @Id
    private val userId: String,
    private val firstName: String,
    private val LastName: String,
    @Enumerated(EnumType.STRING)
    private val roleName: RoleName,
    private val password: String
)

