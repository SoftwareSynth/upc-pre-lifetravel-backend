package com.nexusnova.lifetravelapi.app.IAM.profile.service;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.CreateAgencyCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.UpdateAgencyPhotoCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Agency;

public interface AgencyCommandService {
    Agency handle(UpdateAgencyPhotoCommand command);
    Agency handle(CreateAgencyCommand command);
}
