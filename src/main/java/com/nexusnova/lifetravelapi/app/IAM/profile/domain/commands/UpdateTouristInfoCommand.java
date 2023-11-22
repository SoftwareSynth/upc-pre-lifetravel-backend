package com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands;

import com.nexusnova.lifetravelapi.app.IAM.profile.resources.requests.TouristRequestDto;

public record UpdateTouristInfoCommand(TouristRequestDto touristRequestDto) {
}
