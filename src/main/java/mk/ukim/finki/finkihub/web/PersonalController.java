package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.Personal;
import mk.ukim.finki.finkihub.service.CourseService;
import mk.ukim.finki.finkihub.service.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/personal")
public class PersonalController {
    private final PersonalService personalService;
    private final CourseService courseService;

    public PersonalController(PersonalService personalService, CourseService courseService) {
        this.personalService = personalService;
        this.courseService = courseService;
    }

    @GetMapping
    public String getPersonalCoursesPage(Model model,
                                         HttpServletRequest request) {
        Personal personal = this.personalService.getActivePersonal(Integer.parseInt(request.getRemoteUser()));
        model.addAttribute("courses", this.personalService.listAllCoursesInPersonal(personal.getID()));
        model.addAttribute("bodyContent", "personal-courses");
        return "master-template";
    }

    @PostMapping("/add-course/{id}")
    public String addCourseToPersonal(@PathVariable Integer id,
                                      Model model,
                                      HttpServletRequest request) {

        if (this.personalService.getActivePersonal(Integer.parseInt(request.getRemoteUser())).getPersonalCourses().size() > 10)
            return "redirect:/courses?error=LimitReached";

        this.personalService.addCourseToPersonal(Integer.parseInt(request.getRemoteUser()), id);
        return "redirect:/courses";
    }

    @PostMapping("/delete-course/{id}")
    public String deleteCourseFromPersonal(@PathVariable Integer id,
                                           HttpServletRequest request) {
        Personal personalToDeleteFrom = this.personalService.getActivePersonal(Integer.parseInt(request.getRemoteUser()));
        personalToDeleteFrom.getPersonalCourses()
                .removeIf(course -> course.getID().equals(id));
        this.personalService.save(personalToDeleteFrom);
        return "redirect:/personal";
    }

}
