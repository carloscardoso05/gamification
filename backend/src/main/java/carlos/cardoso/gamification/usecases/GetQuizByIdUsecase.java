package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.dtos.quiz.GetQuizByIdResponse;
import carlos.cardoso.gamification.entities.Quiz;
import carlos.cardoso.gamification.entities.QuizId;
import carlos.cardoso.gamification.entities.UserId;
import carlos.cardoso.gamification.exceptions.ResourceNotFoundException;
import carlos.cardoso.gamification.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GetQuizByIdUsecase {
    private final QuizRepository quizRepository;

    public GetQuizByIdResponse execute(UserId userId, QuizId quizId) {
        Quiz quiz = quizRepository.findVisibleById(quizId, userId)
                                  .orElseThrow(() -> new ResourceNotFoundException(Quiz.class, quizId));
        return new GetQuizByIdResponse(quiz);
    }
}
