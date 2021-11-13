package mrs.domain.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class User (
    @Id
    private val userid: String,
    private val firstName: String,
    private val LastName: String,
    private val password: String,
    private val roleName: RoleName
)

