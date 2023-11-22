package com.nexusnova.lifetravelapi.app.IAM.profile.service;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.queries.GetTouristByUserId;

public interface TouristQueryService {

    Tourist handle(GetTouristByUserId query);
}
