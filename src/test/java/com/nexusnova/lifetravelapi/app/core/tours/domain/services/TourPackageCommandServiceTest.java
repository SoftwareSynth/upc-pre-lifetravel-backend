package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.application.TourPackageCommandServiceImpl;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.RegisterPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.DestinationRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TourPackageRequestDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TourPackageCommandServiceTest {

    private TourPackageCommandService tourPackageCommandService;
    private TourPackageRepository tourPackageRepository;

    @BeforeEach
    void setUp() {
        tourPackageRepository = mock(TourPackageRepository.class);
        DestinationRepository destinationRepository = mock(DestinationRepository.class);
        ValidationUtil validationUtil = mock(ValidationUtil.class);
        tourPackageCommandService = new TourPackageCommandServiceImpl(tourPackageRepository, validationUtil, destinationRepository);
    }

    @Test
    void handle_WhenValidRegisterPackageCommand_ExpectRegisteredTourPackage() {
        // Arrange
        RegisterPackageCommand command = new RegisterPackageCommand(new TourPackageRequestDto());
        TourPackage expectedTourPackage = new TourPackage();

        when(tourPackageRepository.save(expectedTourPackage)).thenReturn(expectedTourPackage);

        // Act
        TourPackage result = tourPackageCommandService.handle(command);

        // Assert
        assertNotNull(result);
        assertEquals(expectedTourPackage, result);
    }

    @Test
    void handle_WhenNullRegisterPackageCommand_ExpectIllegalArgumentException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageCommandService.handle((RegisterPackageCommand) null));
    }

    @Test
    void handle_WhenNullTourPackageRequestDto_ExpectIllegalArgumentException() {
        // Arrange
        RegisterPackageCommand command = new RegisterPackageCommand(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageCommandService.handle(command));
    }

    @Test
    void handle_WhenEmptyTourPackageRequestDto_ExpectIllegalArgumentException() {
        // Arrange
        RegisterPackageCommand command = new RegisterPackageCommand(new TourPackageRequestDto());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageCommandService.handle(command));
    }

    @Test
    void handle_WhenSaveFails_ExpectRuntimeException() {
        // Arrange
        RegisterPackageCommand command = new RegisterPackageCommand(new TourPackageRequestDto());

        when(tourPackageRepository.save(new TourPackage())).thenThrow(RuntimeException.class);
        // Act & Assert
        assertThrows(RuntimeException.class, () -> tourPackageCommandService.handle(command));
    }
}