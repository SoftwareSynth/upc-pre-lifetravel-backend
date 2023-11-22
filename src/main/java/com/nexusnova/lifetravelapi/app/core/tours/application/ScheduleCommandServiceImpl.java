package com.nexusnova.lifetravelapi.app.core.tours.application;


import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.CreateScheduleCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.DeleteExistingSchedulesOfPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.ScheduleRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.ScheduleCommandService;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ScheduleDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleCommandServiceImpl implements  ScheduleCommandService{

    private final ScheduleRepository scheduleRepository;
    private final TourPackageRepository tourPackageRepository;
    private final ValidationUtil validationUtil;

    public ScheduleCommandServiceImpl(ScheduleRepository scheduleRepository,
                                      ValidationUtil validationUtil,
                                      TourPackageRepository tourPackageRepository) {
        this.scheduleRepository = scheduleRepository;
        this.validationUtil = validationUtil;
        this.tourPackageRepository = tourPackageRepository;
    }

    @Override
    @Transactional
    public List<Schedule> handle(CreateScheduleCommand command) {
        //delete all schedules of package
        for (ScheduleDto dto : command.scheduleDto()) {
            scheduleRepository.findById(dto.getId()).ifPresent(scheduleRepository::delete);
        }
        TourPackage tourPackage = validationUtil.findTourPackageById(command.packageId());
        System.out.println("command.scheduleDto().size() = " + tourPackage.getSchedules().size());

        List<Schedule> schedules = new ArrayList<>();
        for (ScheduleDto dto : command.scheduleDto()) {
            Schedule schedule = getSchedule(dto, tourPackage);
            scheduleRepository.save(schedule);
            schedules.add(schedule);
        }
        return schedules;
    }

    private static Schedule getSchedule(ScheduleDto dto, TourPackage tourPackage) {
        Schedule schedule = new Schedule();
        schedule.setTourPackage(tourPackage);
        schedule.setDay(dto.getDay());
        schedule.setStartHour(dto.getHourRange().getStart().getHour());
        schedule.setStartMinute(dto.getHourRange().getStart().getMinute());
        schedule.setStartDayTime(dto.getHourRange().getStart().getDayTime());

        schedule.setEndHour(dto.getHourRange().getEnd().getHour());
        schedule.setEndMinute(dto.getHourRange().getEnd().getMinute());
        schedule.setEndDayTime(dto.getHourRange().getEnd().getDayTime());
        return schedule;
    }
}
