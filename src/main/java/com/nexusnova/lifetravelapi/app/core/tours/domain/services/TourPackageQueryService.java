package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackageByIdQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByAgencyIdAndVisibilityQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByAgencyUserIdQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByRegionQuery;

import java.util.List;

public interface TourPackageQueryService {

    List<TourPackage> handle();
    List<TourPackage> handle(GetTourPackagesByRegionQuery query);
    List<TourPackage> handle(GetTourPackagesByAgencyUserIdQuery query);
    List<TourPackage> handle(GetTourPackagesByAgencyIdAndVisibilityQuery query);
    TourPackage handle(GetTourPackageByIdQuery query);
}
