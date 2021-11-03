package mrs.app.login

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {
    @GetMapping("/hello")
    fun login(): String {
        return "hello"
    }
}