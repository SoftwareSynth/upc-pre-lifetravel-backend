package com.nexusnova.lifetravelapi.app.IOT.domain.repositories;

import com.nexusnova.lifetravelapi.app.IOT.domain.model.WeightBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightBalanceRepository extends JpaRepository<WeightBalance, Long> {
}
