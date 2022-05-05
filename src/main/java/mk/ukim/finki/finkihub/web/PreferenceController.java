package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.service.PreferenceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/preference")
public class PreferenceController {
    private final PreferenceService preferenceService;

    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @GetMapping("/change")
    public String getChangePreference(Model model) {
        model.addAttribute("preferences", this.preferenceService.findAll());
        return "change-preference";
    }

    @PostMapping("/change")
    public String changePreference(HttpServletRequest request,
                                   @RequestParam Integer id) {
        this.preferenceService.changePreference(id, Integer.parseInt(request.getRemoteUser()));
        return "redirect:/courses/filtered";
    }

}
