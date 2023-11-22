package com.nexusnova.lifetravelapi.app.core.tours.api.REST;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Region;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.RegionRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.RegionQueryService;
import com.nexusnova.lifetravelapi.app.core.tours.mapper.RegionMapper;
import com.nexusnova.lifetravelapi.app.core.tours.resources.details.RegionDetail;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/regions")
@Tag(name="Region Controller")
@CrossOrigin
public class RegionController {
    private final RegionQueryService regionQueryService;
    private final RegionMapper regionMapper;
    public RegionController(RegionQueryService regionQueryService,
                            RegionMapper regionMapper) {
        this.regionQueryService = regionQueryService;
        this.regionMapper = regionMapper;
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get Region By Id")
    public RegionDetail getRegionById(@PathVariable("id") Long id) {
        Region region = regionQueryService.handle(id);
        return regionMapper.regionToDetail(region);
    }
}
