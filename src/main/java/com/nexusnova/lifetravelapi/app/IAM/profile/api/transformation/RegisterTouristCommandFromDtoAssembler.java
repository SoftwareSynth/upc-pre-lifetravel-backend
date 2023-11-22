package com.nexusnova.lifetravelapi.app.IAM.profile.api.transformation;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.CreateTouristCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.resources.requests.TouristRequestDto;

public class RegisterTouristCommandFromDtoAssembler {
    public static CreateTouristCommand toCommandFromDto(String uid, TouristRequestDto requestDto){
        return new CreateTouristCommand(uid, requestDto);
    }
}
