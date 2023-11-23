package com.nexusnova.lifetravelapi.app.IAM.identity.application;

import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.AuthenticateUserCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.DeleteUserCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.RegisterUserAgencyCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.RegisterUserTouristCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.Role;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.repositories.UserRepository;
import com.nexusnova.lifetravelapi.app.IAM.identity.resources.requests.UserRequestDto;
import com.nexusnova.lifetravelapi.app.IAM.identity.service.UserCommandService;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository,
                                  ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public User handle(RegisterUserTouristCommand registerUserCommand) {
        User user = new User();
        Role role = validationUtil.getTouristRole();
        if (registerUserCommand.userRequestDto().getId() == null) {
            throw new IllegalArgumentException("Invalid command");
        }


        return getUser(user, role, registerUserCommand.userRequestDto());
    }

    @Override
    public User handle(RegisterUserAgencyCommand registerUserCommand) {
        User user = new User();
        Role role = validationUtil.getAgencyRole();

        return getUser(user, role, registerUserCommand.userRequestDto());
    }
    @Override
    public User handle(AuthenticateUserCommand authenticateUserCommand) {
        if (authenticateUserCommand.email() == null || authenticateUserCommand.password() == null) {
            throw new IllegalArgumentException("Invalid command");
        }
        User user = validationUtil.findUserById(authenticateUserCommand.userId());
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User handle(DeleteUserCommand deleteUserCommand) {
        User user = validationUtil.findUserById(deleteUserCommand.userId());
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.delete(user);
        return user;
    }

    private User getUser(User user, Role role, UserRequestDto userRequestDto) {
        user.setId(userRequestDto.getId());
        user.setEmail(userRequestDto.getEmail());
        user.setGoogleName(userRequestDto.getName());
        user.setGooglePhotoUrl(userRequestDto.getPhotoUrl());
        user.setRole(role);

        userRepository.save(user);
        return user;
    }

}
