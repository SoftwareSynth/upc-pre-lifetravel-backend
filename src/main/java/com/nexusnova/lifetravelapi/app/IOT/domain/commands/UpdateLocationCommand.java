package com.nexusnova.lifetravelapi.app.IOT.domain.commands;

import com.nexusnova.lifetravelapi.app.IOT.resources.requests.TrackingWereableRequestDto;

public record UpdateLocationCommand(Long id, TrackingWereableRequestDto requestDto) {
}
