package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Department;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Region;

import java.util.List;

public interface RegionQueryService {
    Region handle(Long id);
    List<Department> handle();
}
