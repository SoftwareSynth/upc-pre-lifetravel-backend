package com.nexusnova.lifetravelapi.app.IAM.identity.api.transformation;

import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.RegisterUserTouristCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.resources.requests.UserRequestDto;

public class RegisterUserTouristCommandFromRequestDtoAssembler {
    public static RegisterUserTouristCommand toCommandFromDto(UserRequestDto requestDto){
        return new RegisterUserTouristCommand(requestDto);
    }
}
