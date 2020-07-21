package com.employee.employee.rest;

import com.employee.employee.api.model.ChangePasswordRequest;
import com.employee.employee.api.model.Employee;
import com.employee.employee.api.model.EmployeeRequest;
import com.employee.employee.api.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@RestController
@RequestMapping(value="/employee")
@Api(tags = "employee")
public class EmployeeRest {

    EmployeeService employeeService;

    @ApiOperation(value = "Add Employee")
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @ApiOperation(value = "Get all")
    @GetMapping
    public List<Employee> getAll() {return employeeService.getAll(); }

    @ApiOperation(value = "Get employee")
    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable Long id){ return employeeService.getEmployee(id);}

    @ApiOperation(value = "Delete employee")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){ employeeService.delete(id);}

    @ApiOperation(value = "Find employee by email")
    @GetMapping("find/{email}")
    public List<Employee> findAllEmployeesByEmail(@PathVariable String email){
        return employeeService.findAllEmployeesByEmail(email);
    }

    @ApiOperation(value= "Update employee" )
    @PutMapping("{id}/update")
    public Employee update(@PathVariable Long id, @RequestBody EmployeeRequest request){ return employeeService.update(id, request);}

    @ApiOperation(value = "Change password")
    @PutMapping("{id}/change-password")
    public Employee changePassword(@PathVariable Long id, @RequestBody ChangePasswordRequest request){
        return employeeService.changePassword(id, request);
    }

    @ApiOperation(value = "Upload Avatar")
    @PostMapping("{id}/avatar")
    public Employee uploadAvatar(@PathVariable Long id, @RequestBody(required = false) MultipartFile file) throws IOException {
       return employeeService.uploadAvatar(id, file);
    }

}
