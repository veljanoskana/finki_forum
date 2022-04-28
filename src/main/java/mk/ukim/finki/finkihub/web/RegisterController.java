package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.Preference;
import mk.ukim.finki.finkihub.models.Program;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.service.PreferenceService;
import mk.ukim.finki.finkihub.service.ProgramService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final PreferenceService preferenceService;
    private final ProgramService programService;

    public RegisterController(PreferenceService preferenceService, ProgramService programService) {
        this.preferenceService = preferenceService;
        this.programService = programService;
    }

    @GetMapping
    String getForm(Model model){
        List<Preference> preferences = this.preferenceService.findAll();
        List<Program> programs = this.programService.findAll();
        model.addAttribute("preferences", preferences);
        model.addAttribute("programs", programs);
        return "register";
    }

}
