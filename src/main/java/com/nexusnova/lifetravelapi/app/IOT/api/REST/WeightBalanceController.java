package com.nexusnova.lifetravelapi.app.IOT.api.REST;

import com.nexusnova.lifetravelapi.app.IOT.api.transformation.UpdateWeightBalanceCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.WeightBalance;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.WeightBalanceCommandService;
import com.nexusnova.lifetravelapi.app.IOT.mapper.IOTMapper;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeightBalanceRequestDto;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.WeightBalanceSummaryDto;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.WEIGHT_BALANCE_UPDATED;

@RestController
@RequestMapping("/api/v1/weight-balances")
@Tag(name="Weight Sensors Controller")
@CrossOrigin
public class WeightBalanceController {

    private final WeightBalanceCommandService weightBalanceCommandService;
    private final IOTMapper iotMapper;

    @Autowired
    public WeightBalanceController(WeightBalanceCommandService weightBalanceCommandService,
                                   IOTMapper iotMapper) {
        this.weightBalanceCommandService = weightBalanceCommandService;
        this.iotMapper = iotMapper;
    }

    @PutMapping("/update-weight/{balanceId}")
    @Operation(summary = "Actualizar Peso", description = "Permite actualizar el peso de la balanza.")
    public WeightBalanceSummaryDto updateWeight(@Parameter @PathVariable("balanceId") Long balanceId,
                                                @RequestBody @Valid WeightBalanceRequestDto requestDto,
                                                HttpServletResponse response) {
        WeightBalance balance =
                weightBalanceCommandService.handle(UpdateWeightBalanceCommandFromRequestDtoAssembler.toCommandFromDto(balanceId, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, WEIGHT_BALANCE_UPDATED);
        return iotMapper.balanceToSummaryDto(balance);
    }
}
