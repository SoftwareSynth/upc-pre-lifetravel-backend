package com.nexusnova.lifetravelapi.app.IOT.domain.services;

import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateLocationCommand;

public interface TrackingWearableCommandService {
    void handle(UpdateLocationCommand command);
}
