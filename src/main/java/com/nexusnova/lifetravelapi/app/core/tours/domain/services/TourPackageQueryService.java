package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.*;

import java.util.List;

public interface TourPackageQueryService {

    List<TourPackage> handle();
    List<TourPackage> handle(GetTourPackagesByRegionQuery query);
    List<TourPackage> handle(GetTourPackagesByAgencyUserIdQuery query);
    List<TourPackage> handle(GetTourPackagesByAgencyIdAndVisibilityQuery query);
    List<TourPackage> handle(GetTourPackagesByPriceQuery query);
    TourPackage handle(GetTourPackageByIdQuery query);
}
