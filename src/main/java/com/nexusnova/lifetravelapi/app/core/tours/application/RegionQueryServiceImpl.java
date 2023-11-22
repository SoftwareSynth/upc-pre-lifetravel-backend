package com.nexusnova.lifetravelapi.app.core.tours.application;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Department;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Region;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.DepartmentRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.RegionRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.RegionQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionQueryServiceImpl implements RegionQueryService {
    RegionRepository regionRepository;
    DepartmentRepository departmentRepository;
    public RegionQueryServiceImpl(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Region handle(Long id) {
        return regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Region not found"));
    }

    @Override
    public List<Department> handle() {
        return departmentRepository.findAll();
    }

}
