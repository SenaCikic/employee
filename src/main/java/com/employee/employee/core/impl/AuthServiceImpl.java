package com.employee.employee.core.impl;

import com.employee.employee.api.model.LoginRequest;
import com.employee.employee.api.model.LoginResponse;
import com.employee.employee.api.service.AuthService;
import com.employee.employee.dao.entity.EmployeeEntity;
import com.employee.employee.dao.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {


    EmployeeRepository employeeRepository;


    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        EmployeeEntity entity = employeeRepository.getUserByEmail(loginRequest.getEmail());

        if(entity == null){
            throw new Exception("User not found");
        }
        else {
            if(bCryptPasswordEncoder.matches(loginRequest.getPassword(),loginRequest.getEmail())){
                throw  new Exception("Incorrect password");
            }
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setEmail(entity.getEmail());
            loginResponse.setId(entity.getId());
            return loginResponse;
    }
    }
}
