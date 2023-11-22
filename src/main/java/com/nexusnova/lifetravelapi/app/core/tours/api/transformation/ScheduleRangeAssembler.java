package com.nexusnova.lifetravelapi.app.core.tours.api.transformation;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.HourRangeDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ScheduleDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TimeDto;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.enums.VehicleStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleRangeAssembler {

    public List<ScheduleDto> toSummariesFromData(List<Schedule> schedules) {

        List<ScheduleDto> summaries = new ArrayList<>();

        for(Schedule schedule : schedules) {
            ScheduleDto summary = toSummaryFromData(schedule);
            summaries.add(summary);
        }

        return summaries;
    }

    public ScheduleDto toSummaryFromData(Schedule schedule) {

        ScheduleDto summary = new ScheduleDto();
        HourRangeDto hourRange = new HourRangeDto();
        TimeDto startTime = new TimeDto();
        TimeDto endTime = new TimeDto();
        summary.setId(schedule.getId());
        startTime.setHour(schedule.getStartHour());
        startTime.setMinute(schedule.getStartMinute());
        startTime.setDayTime(schedule.getStartDayTime());

        endTime.setHour(schedule.getEndHour());
        endTime.setMinute(schedule.getEndMinute());
        endTime.setDayTime(schedule.getEndDayTime());

        hourRange.setStart(startTime);
        hourRange.setEnd(endTime);

        summary.setDay(schedule.getDay());
        summary.setHourRange(hourRange);
        return summary;
    }
}
