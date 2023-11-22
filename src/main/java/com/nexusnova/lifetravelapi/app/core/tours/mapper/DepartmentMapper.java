package com.nexusnova.lifetravelapi.app.core.tours.mapper;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Department;
import com.nexusnova.lifetravelapi.app.core.tours.resources.details.DepartmentDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mappings({
            @Mapping(target = "name", source = "department.name")
    })
    DepartmentDetail toDetail(Department department);

    List<DepartmentDetail> toDetail(List<Department> departments);
}
