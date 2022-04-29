package mk.ukim.finki.finkihub.web;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LogInController {
    private final StudentService studentService;

    public LogInController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model){
        return "redirect:/courses";
    }
}
