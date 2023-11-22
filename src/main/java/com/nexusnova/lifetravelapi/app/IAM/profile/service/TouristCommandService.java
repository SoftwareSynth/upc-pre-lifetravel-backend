package com.nexusnova.lifetravelapi.app.IAM.profile.service;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.CreateTouristCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.UpdateTouristInfoCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;

public interface TouristCommandService {

    Tourist handle(UpdateTouristInfoCommand command);
    Tourist handle(CreateTouristCommand command);
}
