package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    private final CourseService courseService;

    public TestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getProfessors(Model model){
        model.addAttribute("courses", courseService.findAll());
        return "test";
    }
}
