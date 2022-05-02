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

import java.util.Collections;
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
        if (error != null)
            model.addAttribute("errorMessage", error);
        List<Course> courses = this.courseService.findAll()
                .stream()
                .filter(course -> !this.personalService.getActivePersonal(191005).getPersonalCourses().contains(course))
                .collect(Collectors.toList());
        model.addAttribute("courses", courses);
        model.addAttribute("bodyContent", "allCourses");
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
        model.addAttribute("comments", commentsForCourse);
        model.addAttribute("course", course);

        if (this.personalService.getActivePersonal(191005).getPersonalCourses().contains(course))
            course.setMyCourse(true);

        model.addAttribute("myCourse", course.isMyCourse());
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
        model.addAttribute("bodyContent", "filteredCourses");

        return "master-template";
    }

}
