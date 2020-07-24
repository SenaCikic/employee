package com.employee.employee.rest;

import com.employee.employee.api.model.LoginRequest;
import com.employee.employee.api.model.LoginResponse;
import com.employee.employee.api.service.AuthService;
import com.employee.employee.web.CustomAuthenticationProvider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@RequestMapping(value="/")
@RestController
public class AuthRest {

    AuthService authService;

    CustomAuthenticationProvider authenticationProvider;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        if(authentication != null) {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            return authService.login(loginRequest);
        }
        else {
            throw new Exception("Error with authentication");
        }
        }
    }

