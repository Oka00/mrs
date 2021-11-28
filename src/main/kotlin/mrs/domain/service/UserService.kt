package mrs.domain.service

import mrs.domain.model.User
import mrs.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class UserService(val userRepository: UserRepository) : UserDetailsService {

    // TODO: Null対応
    // TODO: transactionいつ使うべきか考える
    @Transactional(readOnly=true)
    fun findByUserId(userId: String): User{
        return userRepository.findByUserId(userId)
    }

    @Transactional(readOnly=true)
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(userId: String): UserDetails {
        return Optional.ofNullable(userRepository.findByUserId(userId))
            .orElseThrow{ UsernameNotFoundException("User not found.") }
    }


}