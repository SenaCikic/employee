package com.employee.employee.core.mapper;

import com.employee.employee.api.model.DocStore;
import com.employee.employee.dao.entity.DocStoreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocStoreMapper {

    @Mapping(source = "employeeId", target = "employee.id")
    DocStoreEntity dtoToEntity(DocStore docStore);

    @InheritInverseConfiguration(name = "dtoToEntity")
    DocStore entityToDto(DocStoreEntity docStoreEntity);
}
