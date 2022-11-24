package com.project.astral.registration;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/registration")
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService regService; 

    public String register(@RequestBody RegistrationRequest request){
        return regService.register(request);
    }
}
