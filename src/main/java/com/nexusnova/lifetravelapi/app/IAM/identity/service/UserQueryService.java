package com.nexusnova.lifetravelapi.app.IAM.identity.service;

import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.queries.GetUserByIdQuery;

public interface UserQueryService {

    User handle(GetUserByIdQuery query);
}
