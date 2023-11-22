package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description="Schedule (Request)")
public class ScheduleDto {
    private Long id;
    @Schema(description="Dia")
    private String day;
    @Schema(description="Rango de Hora")
    private HourRangeDto hourRange;

    public void setDay(String day) {
        this.day = day;
    }

    public void setHourRange(HourRangeDto hourRange) {
        this.hourRange = hourRange;
    }
}
