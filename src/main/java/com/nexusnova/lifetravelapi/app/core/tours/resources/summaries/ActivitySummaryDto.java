package com.nexusnova.lifetravelapi.app.core.tours.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description="Activity (Summary)")
public class ActivitySummaryDto {
    private Long id;
    private String title;
    private String imgUrl;
}
