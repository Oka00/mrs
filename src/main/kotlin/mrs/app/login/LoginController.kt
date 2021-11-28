package mrs.app.login

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.view.RedirectView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Controller
class LoginController {
    @GetMapping("/loginForm")
    fun showLoginForm(): String {
        return "loginForm"
    }
}