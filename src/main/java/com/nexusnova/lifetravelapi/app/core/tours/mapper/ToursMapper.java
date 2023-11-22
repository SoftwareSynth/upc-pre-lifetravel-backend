package com.nexusnova.lifetravelapi.app.core.tours.mapper;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.*;
import com.nexusnova.lifetravelapi.app.core.tours.resources.details.*;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.LocationNameDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.summaries.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToursMapper {
    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "title", source = "entity.title"),
            @Mapping(target = "imgUrl", source = "entity.imgUrl"),
    })
    ActivitySummaryDto activityToSummaryDto(Activity entity);
    List<ActivitySummaryDto> activityToSummaryDtos(List<Activity> entities);
    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "destiny", source = "entity.department.name"),
            @Mapping(target = "title", source = "entity.title"),
            @Mapping(target = "description", source = "entity.description"),
            @Mapping(target = "price", source = "entity.price"),
            @Mapping(target = "rating", source = "entity.rating"),
            @Mapping(target = "imgUrl", source = "entity.imgUrl"),
            @Mapping(target = "visible", source = "entity.visible"),
    })
    TourPackageSummaryDto tourPackageToSummaryDto(TourPackage entity);
    List<TourPackageSummaryDto> tourPackageToSummaryDtos(List<TourPackage> entities);
    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "title", source = "entity.title"),
            @Mapping(target = "destiny", source = "entity.department.name"),
            @Mapping(target = "agencyId", source = "entity.agency.user.id"),
            @Mapping(target = "description", source = "entity.description"),
            @Mapping(target = "imgUrl", source = "entity.imgUrl"),
            @Mapping(target = "rating", source = "entity.rating"),
            @Mapping(target = "meetingPointLatitude", source = "entity.latitude"),
            @Mapping(target = "meetingPointLongitude", source = "entity.longitude"),
            @Mapping(target = "activities", source = "entity.activities"),
            @Mapping(target = "destinations", source = "entity.destinations"),
            //@Mapping(target = "schedules", source = "entity.schedules"),
    })
    TourPackageDetailDto tourPackageToDetailDto(TourPackage entity);
    List<TourPackageDetailDto> tourPackageToDetailDtos(List<TourPackage> entities);
    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "name", source = "entity.name"),
            @Mapping(target = "latitude", source = "entity.latitude"),
            @Mapping(target = "longitude", source = "entity.longitude"),
    })
    LocationNameDto destinationToLocationNameDto(Destination entity);
    List<LocationNameDto> destinationToLocationNameDtos(List<Destination> entities);
    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "name", source = "dto.name"),
            @Mapping(target = "latitude", source = "dto.latitude"),
            @Mapping(target = "longitude", source = "dto.longitude"),
    })
    Destination locationNameDtoToDestination(LocationNameDto dto);
}
