package com.nexusnova.lifetravelapi.app.IOT.domain.services;

import com.nexusnova.lifetravelapi.app.IOT.domain.queries.GetTrackingWereablesByAgencyQuery;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.TrackingWereableSummayDto;

import java.util.List;

public interface TrackingWereableQueryService {

    List<TrackingWereableSummayDto> handle(GetTrackingWereablesByAgencyQuery query);
}
