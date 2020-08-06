package com.employee.employee.rest;

import com.employee.employee.api.model.Employee;
import com.employee.employee.api.model.LoginRequest;
import com.employee.employee.api.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping(value = "/login")
@Api(tags="login")
@AllArgsConstructor
public class LoginRest {

    EmployeeService employeeService;

    @ApiOperation(value="Login")
    @PostMapping
    public Employee login(@RequestBody LoginRequest loginRequest){
        return employeeService.login(loginRequest);
    }
}
