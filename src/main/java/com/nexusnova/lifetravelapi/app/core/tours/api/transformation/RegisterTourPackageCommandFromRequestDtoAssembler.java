package com.nexusnova.lifetravelapi.app.core.tours.api.transformation;

import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.RegisterPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TourPackageRequestDto;

public class RegisterTourPackageCommandFromRequestDtoAssembler {
    public static RegisterPackageCommand toCommandFromDto(TourPackageRequestDto requestDto) {
        return new RegisterPackageCommand(requestDto);
    }
}