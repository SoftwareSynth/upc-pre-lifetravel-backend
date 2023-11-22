package com.nexusnova.lifetravelapi.app.IAM.profile.application;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.queries.GetAgencyByUserId;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.repositories.AgencyRepository;
import com.nexusnova.lifetravelapi.app.IAM.profile.service.AgencyQueryService;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyQueryServiceImpl implements AgencyQueryService {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyQueryServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public Agency handle(GetAgencyByUserId query) {
        Optional<Agency> agency = agencyRepository.findByUserId(query.userId());

        if(agency.isEmpty()){
            throw new ResourceNotFoundException("Agency user id cant be found");
        }
        return agency.get();
    }
}
