package com.nexusnova.lifetravelapi.app.IOT.api.transformation;

import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateLocationCommand;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.TrackingWereableRequestDto;

public class UpdateLocationCommandFromRequestDtoAssembler {
    public static UpdateLocationCommand toCommandFromDto(Long id, TrackingWereableRequestDto requestDto) {
        return new UpdateLocationCommand(id, requestDto);
    }
}
