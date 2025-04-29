package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.dtos.user.CreateUserRequest;
import carlos.cardoso.gamification.dtos.user.CreateUserResponse;
import carlos.cardoso.gamification.entities.User;
import carlos.cardoso.gamification.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@UseCase
@RequiredArgsConstructor
public class CreateUserUsecase {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public CreateUserResponse execute(CreateUserRequest request) {
        User user = new User() {{
            setName(request.getName());
            setSocialName(request.getSocialName());
            setEmail(request.getEmail());
            setPassword(passwordEncoder.encode(request.getPassword()));
        }};
        userRepository.save(user);
        return new CreateUserResponse(user);
    }
}
