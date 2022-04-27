package mk.ukim.finki.finkihub.web;
import mk.ukim.finki.finkihub.models.Course;
import mk.ukim.finki.finkihub.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    private final CourseService courseService;

    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        List<Course> courses = this.courseService.findAll();
        model.addAttribute("courses", courses);
        return "allCourses";
//        model.addAttribute("bodyContent", "allCourses");
//        return "master-template";
    }

}
