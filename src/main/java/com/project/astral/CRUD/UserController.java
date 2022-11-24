package com.project.astral.CRUD;

import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@NoArgsConstructor
public class UserController {
    
    public UserService UserService;

    @Autowired
    public UserController(UserService UserService){
        this.UserService = UserService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User User) throws IllegalAccessException, ExecutionException, InterruptedException{
        return UserService.createUser(User);
    }

    @GetMapping("/get")
    public User getUser(@RequestParam String documentId) throws IllegalAccessException, ExecutionException, InterruptedException{
        return UserService.getUser(documentId);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User User) throws IllegalAccessException, ExecutionException, InterruptedException{
        return UserService.updateUser(User);
    }

    @PutMapping("/delete")
    public String deleteUser(@RequestParam String documentId) throws IllegalAccessException, ExecutionException{
        return UserService.deleteUser(documentId);
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return ResponseEntity.ok("Test get is working!! :)");
    }

    @GetMapping("/home")
    public List<User> home() throws InterruptedException, ExecutionException{
        return List.of(
            new User(
                "user_3", "Marian", "MariansPass"
            )
        );
    }
}
