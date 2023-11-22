package com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands;

import com.nexusnova.lifetravelapi.app.IAM.profile.resources.requests.AgencyRequestDto;

public record CreateAgencyCommand(String id, AgencyRequestDto agencyRequestDto) {
}
