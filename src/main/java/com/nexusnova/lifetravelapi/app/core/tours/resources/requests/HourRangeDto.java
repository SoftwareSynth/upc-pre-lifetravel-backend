package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Hour Range (Request)")
public class HourRangeDto {

    @Schema(description="start")
    private TimeDto start;
    @Schema(description="end")
    private TimeDto end;

    public TimeDto getStart() {
        return start;
    }

    public void setStart(TimeDto start) {
        this.start = start;
    }

    public TimeDto getEnd() {
        return end;
    }

    public void setEnd(TimeDto end) {
        this.end = end;
    }
}
