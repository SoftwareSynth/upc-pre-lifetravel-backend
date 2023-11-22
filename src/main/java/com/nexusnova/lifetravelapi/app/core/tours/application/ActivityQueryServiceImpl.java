package com.nexusnova.lifetravelapi.app.core.tours.application;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Activity;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.ActivityRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.ActivityQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityQueryServiceImpl implements ActivityQueryService {

    private final ActivityRepository activityRepository;

    public ActivityQueryServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> handle() {
        return activityRepository.findAll();
    }
}
