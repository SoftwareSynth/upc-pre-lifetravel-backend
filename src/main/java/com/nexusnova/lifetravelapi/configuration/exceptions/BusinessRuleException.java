package com.nexusnova.lifetravelapi.configuration.exceptions;

import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.WeatherSummaryDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class BusinessRuleException extends RuntimeException{
    public BusinessRuleException(String message) {
        super(message);
    }

}
