package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description="Activity (Request)")
public class ActivityRequestDto {

    @Schema(description="Activity Id")
    private Long id;
}
