package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.service.CourseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CourseService courseService;

    public AdminController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdminPage(Model model) {
        model.addAttribute("bodyContent", "admin");
        return "master-template";
    }

    @GetMapping("/add-course")
    public String getCourseForm(Model model) {
        model.addAttribute("bodyContent", "course-form");
        return "master-template";
    }

    @GetMapping("/add-preference")
    public String getPreferenceForm(Model model) {
        model.addAttribute("bodyContent", "preference-form");
        return "master-template";
    }

    @GetMapping("/add-professor")
    public String getProfessorForm(Model model) {
        model.addAttribute("bodyContent", "professor-form");
        model.addAttribute("courses", this.courseService.findAll());
        return "master-template";
    }

    @PostMapping("/add-course")
    public String addCourse(HttpServletRequest request) {
        return "redirect:/admin";
    }

    @PostMapping("/add-preference")
    public String addPreference(HttpServletRequest request) {
        return "redirect:/admin";
    }

    @PostMapping("/add-professor")
    public String addProfessor(HttpServletRequest request) {
        return "redirect:/admin";
    }
}
