package com.nexusnova.lifetravelapi.app.IOT.application;

import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateWeightCommand;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.WeightBalance;
import com.nexusnova.lifetravelapi.app.IOT.domain.repositories.WeightBalanceRepository;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.WeightBalanceCommandService;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WeightBalanceCommandServiceImpl implements WeightBalanceCommandService {

    private final WeightBalanceRepository weightBalanceRepository;

    public WeightBalanceCommandServiceImpl(WeightBalanceRepository weightBalanceRepository) {
        this.weightBalanceRepository = weightBalanceRepository;
    }

    @Override
    public WeightBalance handle(UpdateWeightCommand command) {
        WeightBalance weightBalance = weightBalanceRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("WeightBalance not found with id: " + command.id()));

        weightBalance.setWeight(weightBalance.getWeight() + command.requestDto().getWeight());
        weightBalanceRepository.save(weightBalance);
        return weightBalance;
    }
}
