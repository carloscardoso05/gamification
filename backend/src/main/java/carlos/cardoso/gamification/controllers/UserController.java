package carlos.cardoso.gamification.controllers;

import carlos.cardoso.gamification.dtos.user.CreateUserRequest;
import carlos.cardoso.gamification.dtos.user.CreateUserResponse;
import carlos.cardoso.gamification.dtos.user.GetCurrentUserResponse;
import carlos.cardoso.gamification.entities.User;
import carlos.cardoso.gamification.usecases.CreateUserUsecase;
import carlos.cardoso.gamification.usecases.GetCurrentUserUsecase;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "User management")
public class UserController {

    private final CreateUserUsecase createUserUsecase;
    private final GetCurrentUserUsecase getCurrentUserUsecase;

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public GetCurrentUserResponse getCurrentUser(@AuthenticationPrincipal User currentUser) {
        return getCurrentUserUsecase.execute(currentUser);
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        return createUserUsecase.execute(request);
    }
}