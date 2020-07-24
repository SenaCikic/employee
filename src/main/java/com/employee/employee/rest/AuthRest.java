package com.employee.employee.rest;

import com.employee.employee.api.model.LoginRequest;
import com.employee.employee.api.model.LoginResponse;
import com.employee.employee.api.service.AuthService;
import com.employee.employee.web.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRest {

    @Autowired
    private AuthService authService;

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

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

