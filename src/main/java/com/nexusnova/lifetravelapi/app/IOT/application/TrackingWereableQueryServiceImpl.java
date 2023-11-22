package com.nexusnova.lifetravelapi.app.IOT.application;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.TrackingWearable;
import com.nexusnova.lifetravelapi.app.IOT.domain.queries.GetTrackingWereablesByAgencyQuery;
import com.nexusnova.lifetravelapi.app.IOT.domain.repositories.TrackingWereableRepository;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.TrackingWereableQueryService;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.TrackingWereableSummayDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrackingWereableQueryServiceImpl implements TrackingWereableQueryService {

    private final TrackingWereableRepository trackingWereableRepository;
    private final ValidationUtil validationUtil;

    public TrackingWereableQueryServiceImpl(TrackingWereableRepository trackingWereableRepository,
                                            ValidationUtil validationUtil) {
        this.trackingWereableRepository = trackingWereableRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public List<TrackingWereableSummayDto> handle(GetTrackingWereablesByAgencyQuery query) {
        Long firstBookingPackage =
                trackingWereableRepository.findFirstBooking(new Date(),query.agencyUserId()).get(0);
        List<String> users = trackingWereableRepository.findUsersofDay(getMeYesterday(),getMeTomorrow(),
                firstBookingPackage);

        List<TrackingWereableSummayDto> wereables = new ArrayList<>();
        for(String user : users) {
            TrackingWereableSummayDto _summary = new TrackingWereableSummayDto();
            TrackingWearable _gps = trackingWereableRepository.findGPS(user);
            Tourist tourist = validationUtil.findTouristByUserId(user);
            _summary.setId(_gps.getId());
            _summary.setNombre(tourist.getName());
            _summary.setImgUrl(tourist.getPhotoUrl());
            _summary.setLatitude(_gps.getLatitude());
            _summary.setLongitude(_gps.getLongitude());
            wereables.add(_summary);
        }
        return wereables;
    }

    private Date getMeYesterday(){
        return new Date(System.currentTimeMillis()-24*60*60*1000);
    }

    private Date getMeTomorrow(){
        return new Date(System.currentTimeMillis()+24*60*60*1000);
    }
}
