package com.nexusnova.lifetravelapi.app.IOT.domain.commands;

import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeightBalanceRequestDto;

public record UpdateWeightCommand(Long id, WeightBalanceRequestDto requestDto) {
}
