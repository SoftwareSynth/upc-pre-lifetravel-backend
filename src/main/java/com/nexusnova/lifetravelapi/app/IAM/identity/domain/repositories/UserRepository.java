package com.nexusnova.lifetravelapi.app.IAM.identity.domain.repositories;

import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
