package com.example.project.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model, Authentication authentication){
        if (authentication != null) {
            model.addAttribute("title", authentication.getName());
        }
        else
            model.addAttribute("title", "");
        return "login";
    }

}
