package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetSchedulesByPackageQuery;

import java.util.List;

public interface ScheduleQueryService {

    List<Schedule> handle(GetSchedulesByPackageQuery query);
}
