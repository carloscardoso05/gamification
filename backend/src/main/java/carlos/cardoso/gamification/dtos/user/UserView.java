package carlos.cardoso.gamification.dtos.user;

import carlos.cardoso.gamification.entities.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserView {
    private final UUID id;
    private final String name;
    private final String socialName;
    private final String email;

    public UserView(User user) {
        id = user.getId().id();
        name = user.getName();
        socialName = user.getSocialName();
        email = user.getEmail();
    }
}