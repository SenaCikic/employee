package com.employee.employee.core.mapper;

import com.employee.employee.api.model.Employee;
import com.employee.employee.dao.entity.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee entityToDto(EmployeeEntity employeeEntity);

    List<Employee> entitiesToDtos(List<EmployeeEntity> entities);
}
