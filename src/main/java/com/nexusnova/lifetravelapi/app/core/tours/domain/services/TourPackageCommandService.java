package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.ModifyImgPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.ModifyPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.RegisterPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;

public interface TourPackageCommandService {

    TourPackage handle(RegisterPackageCommand command);
    TourPackage handle(ModifyImgPackageCommand command);
    TourPackage handle(ModifyPackageCommand command);

}
