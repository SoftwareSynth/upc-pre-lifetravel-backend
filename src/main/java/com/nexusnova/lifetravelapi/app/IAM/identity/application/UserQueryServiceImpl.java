package com.nexusnova.lifetravelapi.app.IAM.identity.application;

import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.queries.GetUserByIdQuery;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.repositories.UserRepository;
import com.nexusnova.lifetravelapi.app.IAM.identity.service.UserQueryService;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(GetUserByIdQuery query) {
        return userRepository.findById(query.uid())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + query.uid()));
    }
}
