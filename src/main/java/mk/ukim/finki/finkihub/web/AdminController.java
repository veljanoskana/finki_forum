package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.Course;
import mk.ukim.finki.finkihub.models.Preference;
import mk.ukim.finki.finkihub.models.Professor;
import mk.ukim.finki.finkihub.service.CourseService;
import mk.ukim.finki.finkihub.service.PreferenceService;
import mk.ukim.finki.finkihub.service.ProfessorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CourseService courseService;
    private final PreferenceService preferenceService;
    private final ProfessorService professorService;

    public AdminController(CourseService courseService, PreferenceService preferenceService, ProfessorService professorService) {
        this.courseService = courseService;
        this.preferenceService = preferenceService;
        this.professorService = professorService;
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
        model.addAttribute("courses", this.courseService.findAll());
        return "master-template";
    }

    @GetMapping("/add-professor")
    public String getProfessorForm(Model model) {
        model.addAttribute("bodyContent", "professor-form");
        model.addAttribute("courses", this.courseService.findAll());
        return "master-template";
    }

    @PostMapping("/add-course")
    public String addCourse(@RequestParam String courseName,
                            @RequestParam Integer year) {
        this.courseService.save(new Course(courseName, year));
        return "redirect:/admin";
    }

    @PostMapping("/add-preference")
    public String addPreference(@RequestParam String preferenceName,
                                @RequestParam List<Integer> courses) {
        List<Course> coursesInPreference = courses.stream()
                .map(course -> this.courseService.findById(course).get())
                .collect(Collectors.toList());
        this.preferenceService.save(new Preference(preferenceName, coursesInPreference));
        return "redirect:/admin";
    }

    @PostMapping("/add-professor")
    public String addProfessor(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String link,
                               @RequestParam List<Integer> courses) {
        List<Course> teachingCourses = courses.stream()
                .map(course -> this.courseService.findById(course).get())
                .collect(Collectors.toList());
        this.professorService.save(new Professor(firstName, lastName, link, teachingCourses));
        return "redirect:/admin";
    }
}
