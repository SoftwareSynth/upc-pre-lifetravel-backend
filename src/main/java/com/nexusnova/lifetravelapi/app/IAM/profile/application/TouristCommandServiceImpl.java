package com.nexusnova.lifetravelapi.app.IAM.profile.application;

import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.CreateTouristCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.UpdateTouristInfoCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.repositories.TouristRepository;
import com.nexusnova.lifetravelapi.app.IAM.profile.resources.requests.TouristRequestDto;
import com.nexusnova.lifetravelapi.app.IAM.profile.service.TouristCommandService;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import jakarta.jws.soap.SOAPBinding;
import org.springframework.stereotype.Service;

@Service
public class TouristCommandServiceImpl implements TouristCommandService {

    private final TouristRepository touristRepository;
    private final ValidationUtil validationUtil;

    public TouristCommandServiceImpl(TouristRepository touristRepository,
                                     ValidationUtil validationUtil) {
        this.touristRepository = touristRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public Tourist handle(UpdateTouristInfoCommand command) {
        return null;
    }

    @Override
    public Tourist handle(CreateTouristCommand command) {
        Tourist tourist = new Tourist();
        User user = validationUtil.findUserById(command.uid());
        TouristRequestDto requestDto = command.touristRequestDto();

        tourist.setUser(user);
        tourist.setName(requestDto.getName());
        tourist.setBirthDate(requestDto.getBirthDate());
        tourist.setPhoneNumber(requestDto.getPhoneNumber());
        tourist.setPhotoUrl(requestDto.getPhotoUrl());
        tourist.setEmergencyPhoneNumber(requestDto.getEmergencyPhoneNumber());

        touristRepository.save(tourist);
        return tourist;
    }
}
