package com.nexusnova.lifetravelapi.app.core.tours.mapper;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Region;
import com.nexusnova.lifetravelapi.app.core.tours.resources.details.RegionDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface RegionMapper {
    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "title", source = "entity.title"),
            @Mapping(target = "description", source = "entity.description"),
            @Mapping(target = "imgUrl", source = "entity.imgUrl"),
    })
    RegionDetail regionToDetail(Region entity);
}
