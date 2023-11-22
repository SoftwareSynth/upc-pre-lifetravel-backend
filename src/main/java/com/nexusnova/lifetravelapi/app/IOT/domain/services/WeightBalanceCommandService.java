package com.nexusnova.lifetravelapi.app.IOT.domain.services;


import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateWeightCommand;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.WeightBalance;

public interface WeightBalanceCommandService {
    WeightBalance handle(UpdateWeightCommand command);

}
