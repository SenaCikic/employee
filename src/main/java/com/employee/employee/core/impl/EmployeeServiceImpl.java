package com.employee.employee.core.impl;

import com.employee.employee.api.model.ChangePasswordRequest;
import com.employee.employee.api.model.Employee;
import com.employee.employee.api.model.EmployeeRequest;
import com.employee.employee.api.service.EmployeeService;
import com.employee.employee.core.mapper.EmployeeMapper;
import com.employee.employee.dao.entity.EmployeeEntity;
import com.employee.employee.dao.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    @Override
    public Employee addEmployee(Employee employee){
        EmployeeEntity newEmployee = new EmployeeEntity();

        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setHoursActive(employee.getHoursActive());
        newEmployee.setPassword(employee.getPassword());

        newEmployee = employeeRepository.save(newEmployee);

        return employeeMapper.entityToDto(newEmployee);
    }

    @Override
    public List<Employee> getAll(){
        List<EmployeeEntity> entities = employeeRepository.findAll();
        return employeeMapper.entitiesToDtos(entities);
    }

    @Override
    public Employee getEmployee(Long id){
        EmployeeEntity entity = employeeRepository.getOne(id);
        return employeeMapper.entityToDto(entity);
    }

    @Override
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllEmployeesByEmail(String email){
        List<EmployeeEntity> entities = employeeRepository.findEmployeesByEmail(email);
        return employeeMapper.entitiesToDtos(entities);
    }

    public EmployeeEntity setBasicEmployeeInfo(EmployeeRequest request, EmployeeEntity entity){

        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setPhone(request.getPhone());
        entity.setId(request.getId());
        entity.setPassword(request.getPassword());

        return entity;
    }

    @Override
    public Employee update(Long id, EmployeeRequest request){
        EmployeeEntity entity = employeeRepository.findById(id).get();

        entity = setBasicEmployeeInfo(request, entity);

        entity = employeeRepository.save(entity);

        return employeeMapper.entityToDto(entity);

    }

    @Override
    public Employee changePassword(Long id, ChangePasswordRequest request){
        EmployeeEntity entity = employeeRepository.findById(id).get();

            entity.setPassword(request.getNewPassword());
            entity = employeeRepository.save(entity);


        return employeeMapper.entityToDto(entity);
    }

    @Override
    public Employee uploadAvatar(Long id, MultipartFile file) throws IOException {
        EmployeeEntity entity = employeeRepository.findById(id).get();

        String fileName = file.getOriginalFilename();
        if(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")){
            entity.setAvatar(file.getBytes());

            entity.setFirstName(entity.getFirstName());
            entity = employeeRepository.save(entity);
        } else throw new UnsupportedOperationException("Allowed formats: .jpg .jpeg .png");

        return employeeMapper.entityToDto(entity);
    }
}


