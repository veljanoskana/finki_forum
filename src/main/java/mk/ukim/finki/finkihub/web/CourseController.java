package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.*;
import mk.ukim.finki.finkihub.service.CourseService;
import mk.ukim.finki.finkihub.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/", "/courses"})
public class CourseController {
    private final CourseService courseService;
    private final StudentService studentService;

    public CourseController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping()
    public String getCoursesPage(Model model) {
        List<Course> courses = this.courseService.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("bodyContent", "allCourses");
        return "master-template";
    }

    @GetMapping("/details/{id}")
    public String detailCoursePage(@PathVariable Integer id,
                                   Model model) {
        Course course = this.courseService.findById(id).get();
        List<Comment> commentsForCourse = course.getComments();
        model.addAttribute("comments", commentsForCourse);
        model.addAttribute("course", course);
        model.addAttribute("bodyContent", "courseDetails");
        return "master-template";
    }

    @GetMapping("/filtered")
    public String getFilteredPage(Model model) {
        Student currentStudent = this.studentService.findById(191005);
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
                .collect(Collectors.toList());

        model.addAttribute("mandatories", mandatories);
        model.addAttribute("electorials", electorials);
        model.addAttribute("bodyContent", "filteredCourses");

        return "master-template";
    }

}
