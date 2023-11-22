package com.nexusnova.lifetravelapi.app.core.tours.domain.commands;

import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TourPackageRequestDto;

public record RegisterPackageCommand(TourPackageRequestDto tourPackageRequestDto) {
}