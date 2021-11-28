package mrs.config

import mrs.domain.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val userService: UserService,
    ) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity){

        // /cssへのアクセスは全員許可する。
        // それ以外はそれ以外は全部認可対象
        http.authorizeRequests()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/**").authenticated()
            .and()

            // ログインページ、成功後の繊維ページを指定。
            // ログインページ、認証URL へのアクセスは常に許可
            // 成功後は/reservableRoomListに移動
            .formLogin()
            .loginPage("/loginForm")
            .loginProcessingUrl("/login")
            .usernameParameter("name")
            .passwordParameter("password")
            .defaultSuccessUrl("/reservableRoomList", true).permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userService)
            .passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
