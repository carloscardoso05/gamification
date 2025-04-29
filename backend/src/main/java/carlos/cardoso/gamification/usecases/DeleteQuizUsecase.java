package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.entities.Quiz;
import carlos.cardoso.gamification.entities.QuizId;
import carlos.cardoso.gamification.exceptions.ResourceNotFoundException;
import carlos.cardoso.gamification.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteQuizUsecase {
    private final QuizRepository quizRepository;

    public void execute(QuizId quizId) {
        quizRepository.findById(quizId).orElseThrow(() -> new ResourceNotFoundException(Quiz.class, quizId));
        quizRepository.deleteById(quizId);
    }
}
