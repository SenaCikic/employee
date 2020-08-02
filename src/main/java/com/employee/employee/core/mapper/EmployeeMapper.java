package com.employee.employee.core.mapper;

import com.employee.employee.api.model.Employee;
import com.employee.employee.dao.entity.EmployeeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "docStoreId", target = "docStore.id")
    EmployeeEntity dtoToEntity(Employee employee);

    @InheritInverseConfiguration(name = "dtoToEntity")
    Employee entityToDto(EmployeeEntity employeeEntity);

    List<Employee> entitiesToDtos(List<EmployeeEntity> entities);

}
