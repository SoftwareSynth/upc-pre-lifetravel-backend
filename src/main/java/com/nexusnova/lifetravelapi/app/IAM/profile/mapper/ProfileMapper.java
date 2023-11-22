package com.nexusnova.lifetravelapi.app.IAM.profile.mapper;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.IAM.profile.resources.summaries.AgencySummaryDto;
import com.nexusnova.lifetravelapi.app.IAM.profile.resources.summaries.TouristSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "legalName", source = "entity.legalName"),
            @Mapping(target = "agencyPhotoUrl", source = "entity.agencyPhotoUrl"),
            @Mapping(target = "phoneNumber", source = "entity.phoneNumber"),
            @Mapping(target = "email", source = "entity.user.email"),
    })
    AgencySummaryDto agencyToSummaryDto(Agency entity);
    List<AgencySummaryDto> agencyToSummaryDtos(List<Agency> entities);

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "name", source = "entity.name"),
            @Mapping(target = "birthDate", source = "entity.birthDate"),
            @Mapping(target = "phoneNumber", source = "entity.phoneNumber"),
            @Mapping(target = "touristPhotoUrl", source = "entity.photoUrl"),
            @Mapping(target = "email", source = "entity.user.email"),
    })
    TouristSummaryDto touristToSummaryDto(Tourist entity);
    List<TouristSummaryDto> touristToSummaryDtos(List<Tourist> entities);

}
