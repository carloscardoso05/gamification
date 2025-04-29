package carlos.cardoso.gamification.dtos.user;

import carlos.cardoso.gamification.entities.User;

public class GetCurrentUserResponse extends UserView {
    public GetCurrentUserResponse(User user) {
        super(user);
    }
}
