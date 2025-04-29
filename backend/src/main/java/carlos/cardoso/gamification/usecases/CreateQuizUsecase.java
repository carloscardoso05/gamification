package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.dtos.quiz.CreateQuizRequest;
import carlos.cardoso.gamification.dtos.quiz.CreateQuizResponse;
import carlos.cardoso.gamification.entities.Quiz;
import carlos.cardoso.gamification.entities.User;
import carlos.cardoso.gamification.entities.UserId;
import carlos.cardoso.gamification.exceptions.ResourceNotFoundException;
import carlos.cardoso.gamification.repositories.QuizRepository;
import carlos.cardoso.gamification.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateQuizUsecase {
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    public CreateQuizResponse execute(UserId currentUserId, CreateQuizRequest request) {
        User currentUser = userRepository.findById(currentUserId)
                                         .orElseThrow(() -> new ResourceNotFoundException(User.class, currentUserId));

        Quiz quiz = new Quiz() {{
            setTitle(request.getTitle());
            setDescription(request.getDescription());
            setPublic(false);
            setOwner(currentUser);
        }};

        quizRepository.save(quiz);

        return new CreateQuizResponse(quiz);
    }
}
