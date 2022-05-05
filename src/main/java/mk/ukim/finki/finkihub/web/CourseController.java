package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.*;
import mk.ukim.finki.finkihub.service.CourseService;
import mk.ukim.finki.finkihub.service.PersonalService;
import mk.ukim.finki.finkihub.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/", "/courses"})
public class CourseController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final PersonalService personalService;

    public CourseController(CourseService courseService, StudentService studentService, PersonalService personalService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.personalService = personalService;
    }

    @GetMapping()
    public String getCoursesPage(@PathVariable(required = false) String error,
                                 Model model) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("error", error);
            model.addAttribute("hasError", true);
        }

        List<Course> courses = this.courseService.findAll()
                .stream()
                .filter(course -> !this.personalService.getActivePersonal(191005).getPersonalCourses().contains(course))
                .sorted(Comparator.comparing(course -> course.getYear()))
                .collect(Collectors.toList());
        model.addAttribute("courses", courses);
        model.addAttribute("bodyContent", "courses");
        return "master-template";
    }

    @GetMapping("/details/{id}")
    public String detailCoursePage(@PathVariable Integer id,
                                   Model model) {
        Course course = this.courseService.findById(id).get();
        List<Comment> commentsForCourse = course.getComments()
                .stream()
                .sorted(Comparator.comparing(comment -> comment.getTimestamp()))
                .collect(Collectors.toList());

        if (commentsForCourse.isEmpty())
            model.addAttribute("noComments", true);
        else {
            model.addAttribute("comments", commentsForCourse);
            model.addAttribute("course", course);
        }

        if (this.personalService.getActivePersonal(191005).getPersonalCourses().contains(course))
            course.setMyCourse(true);

        model.addAttribute("myCourse", course.isMyCourse());
        model.addAttribute("bodyContent", "details");
        return "master-template";
    }

    @GetMapping("/filtered")
    public String getFilteredPage(Model model) {
        Student currentStudent = this.studentService.findById(191005).get();
        Preference preference = currentStudent.getPreference();
        Program program = currentStudent.getProgram();

        int year = currentStudent.getYear();

        List<Course> mandatories = program.getCoursesInProgram()
                .stream()
                .filter(course -> course.getYear().equals(year))
                .collect(Collectors.toList());

        List<Course> electorials = preference.getSuggestedCourses()
                .stream()
                .filter(course -> course.getYear().equals(year))
                .filter(course -> !program.getCoursesInProgram().contains(course))
                .collect(Collectors.toList());

        List<Course> others = this.courseService.findAll()
                .stream()
                .filter(course -> course.getYear().equals(year))
                .filter(course -> !mandatories.contains(course) && !electorials.contains(course))
                .collect(Collectors.toList());

        model.addAttribute("mandatories", mandatories);
        model.addAttribute("electorials", electorials);
        model.addAttribute("others", others);
        model.addAttribute("bodyContent", "filtered-courses");

        return "master-template";
    }

    @GetMapping("/search")
    public String searchCourses(@RequestParam String keyword,
                                Model model) {
        List<Course> courses = this.courseService.findAll()
                .stream()
                .filter(course -> course.getName().contains(keyword))
                .collect(Collectors.toList());
        if (courses.isEmpty())
            return "redirect:/courses";
        model.addAttribute("courses", courses);
        model.addAttribute("back", true);
        model.addAttribute("bodyContent", "courses");
        return "master-template";
    }

    @GetMapping("/access_denied")
    public String accessDeniedPage(Model model) {
        model.addAttribute("bodyContent", "access-denied");
        return "accesss-denied";
    }

}
