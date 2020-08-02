package com.employee.employee.api.service;

import com.employee.employee.api.model.*;
import javassist.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAll();

    Employee getEmployee(Long id);

    void delete(Long id);

    List<Employee> findAllEmployeesByEmail(String email);

    Employee update(Long id, EmployeeRequest request);

    Employee changePassword(Long id, ChangePasswordRequest request);

    Employee uploadAvatar(UploadAvatar uploadAvatarrequest);

    DocStore getAvatar(Long id);

}
