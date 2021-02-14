package app.shoppinglist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(HttpSession httpSession) {
        return httpSession.getAttribute("user") == null ? "index" : "home";
    }
}
