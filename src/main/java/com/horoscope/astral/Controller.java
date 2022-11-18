package com.horoscope.astral;

import java.util.Map;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
    @GetMapping
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken){
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }
}
