package com.nexusnova.lifetravelapi.app.IOT.service;

import com.nexusnova.lifetravelapi.app.IOT.application.TrackingWearableCommandServiceImpl;
import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateLocationCommand;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.TrackingWearable;
import com.nexusnova.lifetravelapi.app.IOT.domain.repositories.TrackingWereableRepository;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.TrackingWereableRequestDto;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class TrackingSensorServiceTest {

    @InjectMocks
    private TrackingWearableCommandServiceImpl trackingWereableCommandService;

    @Mock
    private TrackingWereableRepository trackingWereableRepository;

    @Test
    public void testHandleValidCommand() {
        // Create a sample UpdateLocationCommand and associated data
        UpdateLocationCommand command = new UpdateLocationCommand(1L, new TrackingWereableRequestDto());
        command.requestDto().setLatitude(BigDecimal.ONE);
        command.requestDto().setLongitude(BigDecimal.ONE);
        TrackingWearable trackingWereable = new TrackingWearable();
        trackingWereable.setLatitude(BigDecimal.ONE);
        trackingWereable.setLongitude(BigDecimal.ONE);


        // Mock the behavior of the trackingWereableRepository
        Mockito.when(trackingWereableRepository.findById(command.id()))
                .thenReturn(Optional.of(trackingWereable));

        // Call the handle method
        trackingWereableCommandService.handle(command);

        // Verify that the latitude and longitude were updated correctly
        assertSame(command.requestDto().getLatitude(), trackingWereable.getLatitude());
        assertSame(command.requestDto().getLongitude(), trackingWereable.getLongitude());
    }

    @Test
    public void testHandleValidCommandError(){
        UpdateLocationCommand command = new UpdateLocationCommand(1L, new TrackingWereableRequestDto());
        command.requestDto().setLatitude(BigDecimal.ONE);
        command.requestDto().setLongitude(BigDecimal.ONE);

        TrackingWearable trackingWereable = new TrackingWearable();
        trackingWereable.setLatitude(BigDecimal.ONE);
        trackingWereable.setLongitude(BigDecimal.ONE);


        // Mock the behavior of the trackingWereableRepository
        Mockito.when(trackingWereableRepository.findById(command.id()))
                .thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                ()->trackingWereableCommandService.handle(command));

        assertEquals("TrackingWereable not found with id: 1", exception.getMessage());

    }

}
