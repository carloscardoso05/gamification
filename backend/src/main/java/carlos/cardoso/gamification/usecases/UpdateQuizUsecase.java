package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.dtos.quiz.UpdateQuizRequest;
import carlos.cardoso.gamification.dtos.quiz.UpdateQuizResponse;
import carlos.cardoso.gamification.entities.Quiz;
import carlos.cardoso.gamification.entities.QuizId;
import carlos.cardoso.gamification.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateQuizUsecase {
    private final QuizRepository quizRepository;

    public UpdateQuizResponse execute(QuizId quizId, UpdateQuizRequest request) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
        if (request.getTitle() != null) {
            quiz.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            quiz.setDescription(request.getDescription());
        }
        if (request.getIsPublic() != null) {
            quiz.setPublic(request.getIsPublic());
        }
        quizRepository.save(quiz);
        return new UpdateQuizResponse(quiz);
    }
}
