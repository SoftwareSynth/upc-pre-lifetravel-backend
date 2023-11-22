package com.nexusnova.lifetravelapi.app.IOT.application;

import com.nexusnova.lifetravelapi.app.IOT.domain.model.WeatherSensor;
import com.nexusnova.lifetravelapi.app.IOT.domain.queries.GetWeaterByTouristQuery;
import com.nexusnova.lifetravelapi.app.IOT.domain.repositories.WeatherSensorRepository;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.WeatherSensorQueryService;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.WeatherSummaryDto;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Destination;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import com.nexusnova.lifetravelapi.configuration.exceptions.BusinessRuleException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherSensorQueryServiceImpl implements WeatherSensorQueryService {

    private final WeatherSensorRepository weatherSensorRepository;
    private final ValidationUtil validationUtil;

    public WeatherSensorQueryServiceImpl(WeatherSensorRepository weatherSensorRepository,
                                         ValidationUtil validationUtil) {
        this.weatherSensorRepository = weatherSensorRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public WeatherSummaryDto handle(GetWeaterByTouristQuery query) {
        Optional<Long> tourPackageId = weatherSensorRepository.findFirstBooking(new Date(), query.touristUserId());

        if(tourPackageId.isEmpty()) {
            throw new BusinessRuleException("No bookings found for this user");
        }
        List<Destination> destinations = weatherSensorRepository.findFirstWeatherSensor(tourPackageId.get());
        if(destinations.isEmpty()) {
            throw new BusinessRuleException("No weather sensor found for this package");
        }

        WeatherSensor _weatherSensor = weatherSensorRepository.findById(destinations.get(0).getWeatherSensor().getId())
                .orElseThrow(() -> new BusinessRuleException("No weather sensor found for this package"));
        WeatherSummaryDto summaryDto = new WeatherSummaryDto();
        summaryDto.setTemperature(_weatherSensor.getTemperature());
        summaryDto.setHumidity(_weatherSensor.getHumidity());

        if(_weatherSensor.getTemperature() > 21) {
            summaryDto.setClothes(getClothesSunny());
            summaryDto.setObjects(getObjectsSunny());
        }
        else {
            summaryDto.setClothes(getClothesCold());
            summaryDto.setObjects(getObjectsCold());
        }
        return summaryDto;
    }

    private List<String> getClothesSunny(){
        return List.of("T-shirt", "Shorts", "Jeans", "Skirt", "Dress");
    }

    private List<String> getClothesCold(){
        return List.of("Coat", "Jacket", "Sweater", "Long sleeve shirt");
    }

    private List<String> getObjectsSunny(){
        return List.of("Sunglasses", "Sunscreen", "Hat", "Water bottle", "Umbrella");
    }
    private List<String> getObjectsCold(){
        return List.of("Gloves", "Scarf", "Hand Warmer", "Thermo");
    }


}
