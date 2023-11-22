package com.nexusnova.lifetravelapi.app.IAM.identity.service;

import com.nexusnova.lifetravelapi.app.IAM.identity.application.UserCommandServiceImpl;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.RegisterUserTouristCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.Role;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.repositories.UserRepository;
import com.nexusnova.lifetravelapi.app.IAM.identity.resources.requests.UserRequestDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserCommandServiceTest {

    private UserCommandService registerUserTouristCommandService;
    private UserRepository userRepository;
    private ValidationUtil validationUtil;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        validationUtil = mock(ValidationUtil.class);
        registerUserTouristCommandService = new UserCommandServiceImpl(userRepository, validationUtil);
    }

    @Test
    void handle_WhenNullRegisterUserTouristCommand_ExpectNullPointerException() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> registerUserTouristCommandService.handle((RegisterUserTouristCommand) null));
    }

    @Test
    void handle_WhenNullUserRequestDto_ExpectNullPointerException() {
        // Arrange
        RegisterUserTouristCommand command = new RegisterUserTouristCommand(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> registerUserTouristCommandService.handle(command));
    }

    @Test
    void handle_WhenEmptyUserRequestDto_ExpectIllegalArgumentException() {
        // Arrange
        RegisterUserTouristCommand command = new RegisterUserTouristCommand(new UserRequestDto());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> registerUserTouristCommandService.handle(command));
    }

    @Test
    void handle_WhenSaveFails_ExpectRuntimeException() {
        // Arrange
        RegisterUserTouristCommand command = new RegisterUserTouristCommand(new UserRequestDto());

        when(validationUtil.getTouristRole()).thenReturn(new Role());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> registerUserTouristCommandService.handle(command));
    }
}