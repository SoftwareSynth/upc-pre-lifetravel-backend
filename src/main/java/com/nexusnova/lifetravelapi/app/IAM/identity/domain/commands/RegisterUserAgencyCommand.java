package com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands;

import com.nexusnova.lifetravelapi.app.IAM.identity.resources.requests.UserRequestDto;

public record RegisterUserAgencyCommand(UserRequestDto userRequestDto) {
}
