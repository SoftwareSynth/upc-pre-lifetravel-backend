package com.nexusnova.lifetravelapi.app.shared.domain.repositories;

import com.nexusnova.lifetravelapi.app.shared.domain.model.SerieNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SerieNumberRepository extends JpaRepository<SerieNumber, Long> {

    Optional<SerieNumber> findByType(String type);
}