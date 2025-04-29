package carlos.cardoso.gamification.dtos.user;

import carlos.cardoso.gamification.entities.User;

public class CreateUserResponse extends UserView {
    public CreateUserResponse(User user) {
        super(user);
    }
}
