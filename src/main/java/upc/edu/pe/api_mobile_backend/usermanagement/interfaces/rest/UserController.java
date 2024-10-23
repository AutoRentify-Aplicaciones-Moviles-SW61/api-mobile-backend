package upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetAllUsersQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetUserByIdQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.services.UserCommandService;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.services.UserQueryService;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.CreateUserResource;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.UserResource;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.transform.UserResourceFromEntityAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/users", produces = APPLICATION_JSON_VALUE)
@Tag(name = "User")
public class UserController {

    private final UserQueryService userQueryService;

    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers() {
        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);
        var usersResources = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(usersResources);
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var user = userCommandService.handle(createUserCommand);
        if (user.isEmpty()) return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);
        if (user.isEmpty()) return ResponseEntity.notFound().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
}

