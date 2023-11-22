package com.nexusnova.lifetravelapi.app.IOT.service;

import com.nexusnova.lifetravelapi.app.IOT.application.WeatherSensorCommandServiceImpl;
import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateWeatherCommand;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.TrackingWearable;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.WeatherSensor;
import com.nexusnova.lifetravelapi.app.IOT.domain.repositories.WeatherSensorRepository;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeatherSensorRequestDto;
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
public class WeatherCommandServiceTest {

    @InjectMocks
    private WeatherSensorCommandServiceImpl weatherSensorCommandService;

    @Mock
    private WeatherSensorRepository weatherSensorRepository;

    @Test
    public void testHandleValidCommand() {
        // Create a sample UpdateLocationCommand and associated data
        UpdateWeatherCommand command = new UpdateWeatherCommand(1L, new WeatherSensorRequestDto());
        command.requestDto().setTemperature(50.0);
        command.requestDto().setHumidity(88.0);

        WeatherSensor weatherSensor = new WeatherSensor();
        weatherSensor.setTemperature(50.0);
        weatherSensor.setHumidity(88.0);


        // Mock the behavior of the trackingWereableRepository
        Mockito.when(weatherSensorRepository.findById(command.id()))
                .thenReturn(Optional.of(weatherSensor));

        // Call the handle method
        weatherSensorCommandService.handle(command);

        // Verify that the latitude and longitude were updated correctly
        assertSame(command.requestDto().getHumidity(), weatherSensor.getHumidity());
        assertSame(command.requestDto().getTemperature(), weatherSensor.getTemperature());
    }

    @Test
    public void testHandleValidCommandError(){
        UpdateWeatherCommand command = new UpdateWeatherCommand(1L, new WeatherSensorRequestDto());
        command.requestDto().setTemperature(50.0);
        command.requestDto().setHumidity(88.0);

        TrackingWearable trackingWereable = new TrackingWearable();
        trackingWereable.setLatitude(BigDecimal.ONE);
        trackingWereable.setLongitude(BigDecimal.ONE);


        // Mock the behavior of the trackingWereableRepository
        Mockito.when(weatherSensorRepository.findById(command.id()))
                .thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                ()->weatherSensorCommandService.handle(command));

        assertEquals("WeatherSensor not found with id: 1", exception.getMessage());

    }
}
