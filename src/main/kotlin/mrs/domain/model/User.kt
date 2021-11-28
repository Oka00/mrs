package mrs.domain.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name="usr")
class User(
    @Id
    val userId: String,
    private val firstName: String,
    private val lastName: String,
    @Enumerated(EnumType.STRING)
    private val roleName: RoleName,
    private val password: String
): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return AuthorityUtils.createAuthorityList(roleName.name)
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String? {
        return firstName + lastName
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String? {
        return password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}


