package mk.ukim.finki.finkihub.web;
import mk.ukim.finki.finkihub.models.Comment;
import mk.ukim.finki.finkihub.models.Course;
import mk.ukim.finki.finkihub.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/", "/courses"})
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getCoursesPage(Model model) {
        List<Course> courses = this.courseService.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("bodyContent", "allCourses");
        return "master-template";
    }

    @GetMapping("/details/{id}")
    public String detailCoursePage(@PathVariable Integer id,
                                   Model model){
        Course course = this.courseService.findById(id).get();
        List<Comment> commentsForCourse = course.getComments();
        model.addAttribute("comments", commentsForCourse);
        model.addAttribute("course", course);
        model.addAttribute("bodyContent", "courseDetails");
        return "master-template";
    }

    public String getFilteredPage(Model model) {
        return "";
    }

    public String getEnrolledPage(Model model) {
        return "";
    }

}
