package app.shoppinglist.web.controllers;

import app.shoppinglist.domain.entities.enums.CategoryName;
import app.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", productService.findAllByCategoryName(CategoryName.DRINK));
        model.addAttribute("foods", productService.findAllByCategoryName(CategoryName.FOOD));
        model.addAttribute("households", productService.findAllByCategoryName(CategoryName.HOUSEHOLD));
        model.addAttribute("others", productService.findAllByCategoryName(CategoryName.OTHER));

        return "home";
    }
}
