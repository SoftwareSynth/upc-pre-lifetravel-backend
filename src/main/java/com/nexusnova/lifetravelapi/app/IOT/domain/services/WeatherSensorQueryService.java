package com.nexusnova.lifetravelapi.app.IOT.domain.services;

import com.nexusnova.lifetravelapi.app.IOT.domain.queries.GetWeaterByTouristQuery;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.WeatherSummaryDto;

public interface WeatherSensorQueryService {

    WeatherSummaryDto handle(GetWeaterByTouristQuery query);
}
