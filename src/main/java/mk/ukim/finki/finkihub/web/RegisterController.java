package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.Preference;
import mk.ukim.finki.finkihub.models.Program;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.service.PreferenceService;
import mk.ukim.finki.finkihub.service.ProgramService;
import mk.ukim.finki.finkihub.service.StudentService;
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
    private final StudentService studentService;

    public RegisterController(PreferenceService preferenceService, ProgramService programService, StudentService studentService) {
        this.preferenceService = preferenceService;
        this.programService = programService;
        this.studentService = studentService;
    }

    @GetMapping
    public String getForm(Model model) {
        List<Preference> preferences = this.preferenceService.findAll();
        List<Program> programs = this.programService.findAll();
        model.addAttribute("preferences", preferences);
        model.addAttribute("programs", programs);
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String index,
                           @RequestParam String password,
                           @RequestParam String repeat,
                           @RequestParam Integer programId,
                           @RequestParam Integer preferenceId) {

        if (this.studentService.findById(Integer.parseInt(index)).isPresent())
            return "redirect:/register?StudentAlreadyExists";

        if (password.equals(repeat)) {
            Preference preference = this.preferenceService.findById(preferenceId).get();
            Program program = this.programService.findById(programId).get();
            Student student = new Student(Integer.parseInt(index), name, surname, password, preference, program);
            this.studentService.save(student);
            return "redirect:/login";
        } else {
            return "redirect:/register?PasswordsDoNotMatch";
        }
    }

}
