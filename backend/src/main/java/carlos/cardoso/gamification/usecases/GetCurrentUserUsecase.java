package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.dtos.user.GetCurrentUserResponse;
import carlos.cardoso.gamification.entities.User;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GetCurrentUserUsecase {
    public GetCurrentUserResponse execute (User user) {
        return new GetCurrentUserResponse(user);
    }
}
