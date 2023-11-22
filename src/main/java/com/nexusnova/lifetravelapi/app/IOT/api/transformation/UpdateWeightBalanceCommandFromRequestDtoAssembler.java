package com.nexusnova.lifetravelapi.app.IOT.api.transformation;

import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateWeightCommand;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeightBalanceRequestDto;

public class UpdateWeightBalanceCommandFromRequestDtoAssembler {
    public static UpdateWeightCommand toCommandFromDto(Long id, WeightBalanceRequestDto requestDto) {
        return new UpdateWeightCommand(id, requestDto);
    }
}
