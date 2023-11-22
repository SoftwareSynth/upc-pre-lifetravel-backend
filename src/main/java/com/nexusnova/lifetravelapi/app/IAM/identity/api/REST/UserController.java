package com.nexusnova.lifetravelapi.app.IAM.identity.api.REST;

import com.nexusnova.lifetravelapi.app.IAM.identity.api.transformation.RegisterUserAgencyCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IAM.identity.api.transformation.RegisterUserTouristCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.queries.GetUserByIdQuery;
import com.nexusnova.lifetravelapi.app.IAM.identity.mapper.IdentityMapper;
import com.nexusnova.lifetravelapi.app.IAM.identity.resources.requests.UserRequestDto;
import com.nexusnova.lifetravelapi.app.IAM.identity.service.UserCommandService;
import com.nexusnova.lifetravelapi.app.IAM.identity.resources.summaries.UserSummaryDto;
import com.nexusnova.lifetravelapi.app.IAM.identity.service.UserQueryService;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.USER_CREATED;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name="User Controller")
@CrossOrigin
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;
    private final IdentityMapper identityMapper;

    @Autowired
    public UserController(UserCommandService userCommandService,
                          UserQueryService userQueryService,
                          IdentityMapper identityMapper) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
        this.identityMapper = identityMapper;
    }

    @GetMapping("/login/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obtener usuario", description = "Permite obtener un usuario.")
    public UserSummaryDto getUser(@Parameter @PathVariable("id") String id) {
        User user = userQueryService.handle(new GetUserByIdQuery(id));
        return identityMapper.userToSummaryDto(user);
    }

    @PostMapping("/register/tourist")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar usuario", description = "Permite registrar un usuario.")
    public UserSummaryDto registerTourist(@RequestBody @Valid UserRequestDto userRequestDto,
                               HttpServletResponse response) {
        User user = userCommandService.handle(RegisterUserTouristCommandFromRequestDtoAssembler.toCommandFromDto(userRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, USER_CREATED);
        return identityMapper.userToSummaryDto(user);
    }

    @PostMapping("/register/agency")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar usuario", description = "Permite registrar un usuario.")
    public UserSummaryDto registerAgency(@RequestBody @Valid UserRequestDto userRequestDto,
                               HttpServletResponse response) {
        User user = userCommandService.handle(RegisterUserAgencyCommandFromRequestDtoAssembler.toCommandFromDto(userRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, USER_CREATED);
        return identityMapper.userToSummaryDto(user);
    }

}
