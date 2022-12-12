package com.project.astral.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.PluggableSchemaResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("/{username}/{password}/auth")
    public String loginAuth(@PathVariable("username") String username, @PathVariable("password") String password){
        Optional<AppUser> userItem = userRepo.findByUserName(username); 
        AppUser user = userItem.get();  
        
        if ( user != null && user.getPass() == password){
            return "redirect:/home";
         } else {
            Error e = new Error("Wrong credentials");
            System.out.println(e);
            return "redirect:/login";
        } 
    }
     
    @PostMapping("signup")
    public String signup(Model model){
        AppUser newUser = new AppUser();
        model.addAttribute("newUser",newUser);
        return "signup";
    } 

    @PostMapping("register")
    public String register(AppUser appUser){
        userRepo.save(appUser);
        return "redirect:/home";
    }

    @GetMapping("home")
    public String home(Model model){
        AppUser newUser = new AppUser();
        // Add a new user.
        model.addAttribute("newUser",newUser);
        // Edit an existing user. 
        //model.addAttribute("editUser", newUser);
        // List of Users. 
        model.addAttribute("userList", userRepo.findAll());
        return "index";
    }
    
}
