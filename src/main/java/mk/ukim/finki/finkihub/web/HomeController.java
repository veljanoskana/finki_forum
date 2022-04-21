package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.bootstrap.DataHolder;
import mk.ukim.finki.finkihub.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    @GetMapping
    public String getHomePage(Model model) {
        Student s = DataHolder.students.get(0);
        model.addAttribute("student", s);
        return "frontend";
    }

}
