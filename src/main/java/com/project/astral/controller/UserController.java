package com.project.astral.controller;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.PluggableSchemaResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.astral.entity.AppUser;
import com.project.astral.repository.UserRepository;

@Controller
@RequestMapping("/")
public class UserController {
    //new instance
    @Autowired
    private UserRepository userRepo; 
    
   /*  @GetMapping("login")
    public String login(){
        return """;
    } */

    @PostMapping("register")
    public String register(AppUser appUser){
        AppUser newUser = new AppUser();
        return "redirect:/home";
    }

    @GetMapping("home")
    public String home(Model model){
        AppUser newUser = new AppUser();
        model.addAttribute("newUser",newUser );
        model.addAttribute("newUser", newUser);
        model.addAttribute("userList", userRepo.findAll());
        return "index";
    }
    
}
