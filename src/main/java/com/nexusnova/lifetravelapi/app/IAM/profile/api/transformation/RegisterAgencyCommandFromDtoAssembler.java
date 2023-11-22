package com.nexusnova.lifetravelapi.app.IAM.profile.api.transformation;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.CreateAgencyCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.resources.requests.AgencyRequestDto;

public class RegisterAgencyCommandFromDtoAssembler {
    public static CreateAgencyCommand toCommandFromDto(String uid, AgencyRequestDto requestDto){
        return new CreateAgencyCommand(uid, requestDto);
    }
}
