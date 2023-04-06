package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserRegistrationDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initForm() {
        return  new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDTO userRegistrationDTO,
                             BindingResult bidingResult, RedirectAttributes redirectAttributes) {

        System.out.println(userRegistrationDTO.toString());

        if (bidingResult.hasErrors()) {
            //pass errors to template
            //pass dto to template
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BidingResult.userRegistrationDTO", bidingResult);
            redirectAttributes.addFlashAttribute(
                    "userRegistrationDTO", userRegistrationDTO);

            return "redirect:/register";
        }
        //check if passwords match
        //check if username/email is used
        //insert in db
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
