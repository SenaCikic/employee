package com.employee.employee.core.impl;

import com.employee.employee.api.model.*;
import com.employee.employee.api.service.EmployeeService;
import com.employee.employee.core.mapper.DocStoreMapper;
import com.employee.employee.core.mapper.EmployeeMapper;
import com.employee.employee.dao.entity.DocStoreEntity;
import com.employee.employee.dao.entity.EmployeeEntity;
import com.employee.employee.dao.repository.DocStoreRepository;
import com.employee.employee.dao.repository.EmployeeRepository;
import javassist.NotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    DocStoreRepository docStoreRepository;
    DocStoreMapper docStoreMapper;

    PasswordEncoder passwordEncoder;

    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public Employee addEmployee(Employee employee){
        EmployeeEntity newEmployee = new EmployeeEntity();

        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setHoursActive(employee.getHoursActive());
        newEmployee.setPassword(employee.getPassword());
//        newEmployee.setPassword(encodePassword(newEmployee.getPassword()));

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
//        entity.setPassword(encodePassword(request.getPassword()));


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
    public Employee uploadAvatar(UploadAvatar uploadAvatarRequest) {

        EmployeeEntity employeeEntity = employeeRepository.getOne(uploadAvatarRequest.getId());

        if(employeeEntity.getDocStore() == null) {

            DocStoreEntity newDocStore = new DocStoreEntity();

            newDocStore.setId(uploadAvatarRequest.getId());
            newDocStore.setExtension(uploadAvatarRequest.getExtension());
            newDocStore.setFile(uploadAvatarRequest.getFile());
            newDocStore.setFileName(uploadAvatarRequest.getFileName());
            newDocStore.setMimeType(uploadAvatarRequest.getMimeType());
            newDocStore.setTableName("employee");

            docStoreRepository.save(newDocStore);
            employeeEntity.setDocStore(newDocStore);

            return employeeMapper.entityToDto(employeeEntity);
        }
        else {
            DocStoreEntity docStoreEntity = employeeEntity.getDocStore();
            docStoreEntity.setExtension(uploadAvatarRequest.getExtension());
            docStoreEntity.setFile(uploadAvatarRequest.getFile());
            docStoreEntity.setFileName(uploadAvatarRequest.getFileName());
            docStoreEntity.setMimeType(uploadAvatarRequest.getMimeType());
            docStoreRepository.save(docStoreEntity);

            return employeeMapper.entityToDto(employeeEntity);
        }
    }

    @Override
    public DocStore getAvatar(Long id) {
        DocStoreEntity entity = docStoreRepository.getOne(id);
        return  docStoreMapper.entityToDto(entity);
    }


}


