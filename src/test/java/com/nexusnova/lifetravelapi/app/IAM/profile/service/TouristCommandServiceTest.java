package com.nexusnova.lifetravelapi.app.IAM.profile.service;

import com.nexusnova.lifetravelapi.app.IAM.profile.application.TouristCommandServiceImpl;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.commands.UpdateTouristInfoCommand;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.repositories.TouristRepository;
import com.nexusnova.lifetravelapi.app.IAM.profile.resources.requests.TouristRequestDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TouristCommandServiceTest {

    private TouristCommandService updateTouristInfoCommandService;
    private TouristRepository touristRepository;
    private ValidationUtil validationUtil;

    @BeforeEach
    void setUp() {
        touristRepository = mock(TouristRepository.class);
        validationUtil = mock(ValidationUtil.class);
        updateTouristInfoCommandService = new TouristCommandServiceImpl(touristRepository, validationUtil);
    }

    @Test
    void handle_WhenValidUpdateTouristInfoCommand_ExpectUpdatedTourist() {
        // Arrange
        UpdateTouristInfoCommand command = new UpdateTouristInfoCommand(new TouristRequestDto());
        Tourist existingTourist = new Tourist();
        TouristRequestDto requestDto = command.touristRequestDto();

        when(validationUtil.findTouristById(1L)).thenReturn(existingTourist);
        when(touristRepository.save(existingTourist)).thenReturn(existingTourist);

        // Act
        Tourist result = updateTouristInfoCommandService.handle(command);

        // Assert
        assertNotNull(result);
        assertEquals(requestDto.getName(), result.getName());
        assertEquals(requestDto.getBirthDate(), result.getBirthDate());
        assertEquals(requestDto.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(requestDto.getPhotoUrl(), result.getPhotoUrl());
        assertEquals(requestDto.getEmergencyPhoneNumber(), result.getEmergencyPhoneNumber());
    }

    @Test
    void handle_WhenNullUpdateTouristInfoCommand_ExpectNullPointerException() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> updateTouristInfoCommandService.handle((UpdateTouristInfoCommand) null));
    }

    @Test
    void handle_WhenNullTouristRequestDto_ExpectNullPointerException() {
        // Arrange
        UpdateTouristInfoCommand command = new UpdateTouristInfoCommand(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> updateTouristInfoCommandService.handle(command));
    }

    @Test
    void handle_WhenNullTourist_ExpectNullPointerException() {
        // Arrange
        UpdateTouristInfoCommand command = new UpdateTouristInfoCommand(new TouristRequestDto());

        when(validationUtil.findTouristById(1L)).thenReturn(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> updateTouristInfoCommandService.handle(command));
    }

    @Test
    void handle_WhenSaveFails_ExpectRuntimeException() {
        // Arrange
        UpdateTouristInfoCommand command = new UpdateTouristInfoCommand(new TouristRequestDto());
        Tourist existingTourist = new Tourist();

        when(validationUtil.findTouristById(1L)).thenReturn(existingTourist);
        when(touristRepository.save(existingTourist)).thenThrow(new RuntimeException("Save failed"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> updateTouristInfoCommandService.handle(command));
    }
}