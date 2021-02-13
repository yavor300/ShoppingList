package app.shoppinglist.web.controllers;

import app.shoppinglist.domain.models.binding.UserRegisterBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserRegisterBindingModel userRegisterBindingModel,
                                         BindingResult bindingResult,
                                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        //TODO SERVICE REGISTER LOGIC
        return "redirect:login";
    }
}
