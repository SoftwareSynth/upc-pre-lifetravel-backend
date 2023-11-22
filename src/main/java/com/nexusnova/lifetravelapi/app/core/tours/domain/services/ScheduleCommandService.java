package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.CreateScheduleCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.DeleteExistingSchedulesOfPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ScheduleCommandService {

    List<Schedule> handle(CreateScheduleCommand command);
}
