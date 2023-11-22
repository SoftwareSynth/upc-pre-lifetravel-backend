package com.nexusnova.lifetravelapi.app.IAM.profile.service;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.queries.GetAgencyByUserId;

public interface AgencyQueryService {

    Agency handle(GetAgencyByUserId query);
}
