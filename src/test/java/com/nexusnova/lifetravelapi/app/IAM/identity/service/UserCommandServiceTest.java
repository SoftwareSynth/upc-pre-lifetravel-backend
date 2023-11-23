package com.nexusnova.lifetravelapi.app.IAM.identity.service;

import com.nexusnova.lifetravelapi.app.IAM.identity.application.UserCommandServiceImpl;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.AuthenticateUserCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.DeleteUserCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands.RegisterUserTouristCommand;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.Role;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.repositories.UserRepository;
import com.nexusnova.lifetravelapi.app.IAM.identity.resources.requests.UserRequestDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import jakarta.validation.constraints.Null;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserCommandServiceTest {

    private UserCommandService registerUserTouristCommandService;
    private UserCommandService authenticateUserCommandService;
    private UserCommandService deleteUserCommandService;
    private UserRepository userRepository;
    private ValidationUtil validationUtil;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        validationUtil = mock(ValidationUtil.class);
        registerUserTouristCommandService = new UserCommandServiceImpl(userRepository, validationUtil);
        authenticateUserCommandService = new UserCommandServiceImpl(userRepository, validationUtil);
        deleteUserCommandService = new UserCommandServiceImpl(userRepository, validationUtil);

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

    @Test
    void handle_WhenValidAuthenticateUserCommand_ExpectAuthenticatedUser() {
        // Arrange
        AuthenticateUserCommand command = new AuthenticateUserCommand("sample@gmail.com", "samplePassword");
        User existingUser = new User();

        when(validationUtil.findUserById(command.userId())).thenReturn(existingUser);

        // Act
        User result = authenticateUserCommandService.handle(command);

        // Assert
        assertNotNull(result);
        assertEquals(existingUser, result);
    }

    @Test
    void handle_WhenNullAuthenticateUserCommand_ExpectNullPointerException() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> authenticateUserCommandService.handle((RegisterUserTouristCommand) null));
    }

    @Test
    void handle_WhenNullUserId_ExpectIllegalArgumentException() {
        // Arrange
        AuthenticateUserCommand command = new AuthenticateUserCommand(null, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> authenticateUserCommandService.handle(command));
    }

    @Test
    void handle_WhenNullUser_ExpectResourceNotFoundException() {
        // Arrange
        AuthenticateUserCommand command = new AuthenticateUserCommand("sample@gmail.com", "samplePassword");

        when(validationUtil.findUserById(command.userId())).thenReturn(null);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> authenticateUserCommandService.handle(command));
    }

    @Test
    void handle_WhenExceptionThrown_ExpectRuntimeException() {
        // Arrange
        AuthenticateUserCommand command = new AuthenticateUserCommand("sample@gmail.com", "samplePassword");

        when(validationUtil.findUserById(command.userId())).thenThrow(new RuntimeException("Error finding user"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> authenticateUserCommandService.handle(command));
    }
    @Test
    void handle_WhenValidDeleteUserCommand_ExpectDeletedUser() {
        // Arrange
        DeleteUserCommand command = new DeleteUserCommand(1L);
        User existingUser = new User();

        when(validationUtil.findUserById(command.userId())).thenReturn(existingUser);

        // Act
        User result = deleteUserCommandService.handle(command);

        // Assert
        assertNotNull(result);
        assertEquals(existingUser, result);
        verify(userRepository, times(1)).delete(existingUser);
    }

    @Test
    void handle_WhenNullDeleteUserCommand_ExpectNullPointerException() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> deleteUserCommandService.handle((RegisterUserTouristCommand) null));
    }

    @Test
    void handle_WhenDeleteFails_ExpectRuntimeException() {
        // Arrange
        DeleteUserCommand command = new DeleteUserCommand(1L);
        User existingUser = new User();

        when(validationUtil.findUserById(command.userId())).thenReturn(existingUser);
        doThrow(new RuntimeException("Delete failed")).when(userRepository).delete(existingUser);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> deleteUserCommandService.handle(command));
    }

    @Test
    void handle_WhenNullUserId_ExpectNullPointerException() {
        // Arrange
        DeleteUserCommand command = new DeleteUserCommand(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> deleteUserCommandService.handle(command));
    }

    @Test
    void handle_WhenNullUser_ExpectResourceNotFoundExceptionDelete() {
        // Arrange
        DeleteUserCommand command = new DeleteUserCommand(1L);

        when(validationUtil.findUserById(command.userId())).thenReturn(null);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> deleteUserCommandService.handle(command));
    }

    @Test
    void handle_WhenDeleteFails_ExpectRuntimeExceptionOfSec() {
        // Arrange
        DeleteUserCommand command = new DeleteUserCommand(2L);
        User existingUser = new User();

        when(validationUtil.findUserById(command.userId())).thenReturn(existingUser);
        doThrow(new RuntimeException("Delete failed")).when(userRepository).delete(existingUser);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> deleteUserCommandService.handle(command));
    }
}