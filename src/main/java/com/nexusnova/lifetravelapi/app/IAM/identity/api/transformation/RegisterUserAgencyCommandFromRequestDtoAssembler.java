package com.nexusnova.lifetravelapi.app.IAM.identity.api.transformation;

import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.RegisterUserAgencyCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.resources.requests.UserRequestDto;

public class RegisterUserAgencyCommandFromRequestDtoAssembler {
    public static RegisterUserAgencyCommand toCommandFromDto(UserRequestDto requestDto){
        return new RegisterUserAgencyCommand(requestDto);
    }
}
