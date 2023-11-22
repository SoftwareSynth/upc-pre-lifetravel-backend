package com.nexusnova.lifetravelapi.app.core.tours.domain.repositories;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
