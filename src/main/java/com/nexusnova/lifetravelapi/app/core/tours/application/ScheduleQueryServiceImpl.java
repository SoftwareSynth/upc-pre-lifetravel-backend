package com.nexusnova.lifetravelapi.app.core.tours.application;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetSchedulesByPackageQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.ScheduleRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.ScheduleQueryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleQueryServiceImpl implements ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleQueryServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> handle(GetSchedulesByPackageQuery query) {
        return scheduleRepository.finByPackageId(query.packageId());
    }
}
