package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.Personal;
import mk.ukim.finki.finkihub.service.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal")
public class PersonalController {
    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping
    public String getPersonalCoursesPage(Model model){
        Personal personal = this.personalService.getActivePersonal(191005);
        model.addAttribute("courses", this.personalService.listAllCoursesInPersonal(personal.getID()));
        model.addAttribute("bodyContent", "personalCourses");
        return "master-template";
    }

    @PostMapping("/add-course/{id}")
    public String addCourseToPersonal(@PathVariable Integer id){
        this.personalService.addCourseToPersonal(191005, id);
        return "redirect:/personal";
    }
}
