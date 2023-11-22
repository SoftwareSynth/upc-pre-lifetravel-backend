package com.nexusnova.lifetravelapi.app.core.tours.domain.commands;

import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ScheduleDto;

import java.util.List;

public record CreateScheduleCommand(Long packageId, List<ScheduleDto> scheduleDto){
}
