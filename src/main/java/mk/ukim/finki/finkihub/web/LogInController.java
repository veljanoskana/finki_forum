package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.models.exceptions.InvalidArgumentsException;
import mk.ukim.finki.finkihub.models.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.finkihub.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LogInController {

    private final AuthService authService;

    public LogInController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request,
                        Model model) {
        Student student = null;
        try {
            student = this.authService.login(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("user", student);
            return "redirect:/courses";
        } catch (InvalidUserCredentialsException | InvalidArgumentsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }

    }
}
