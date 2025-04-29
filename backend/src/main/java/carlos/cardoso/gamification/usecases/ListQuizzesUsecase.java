package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.dtos.quiz.QuizOverview;
import carlos.cardoso.gamification.entities.UserId;
import carlos.cardoso.gamification.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListQuizzesUsecase {
    private final QuizRepository quizRepository;

    public List<QuizOverview> execute(UserId userId) {
        return quizRepository.findAllVisibleToUser(userId)
                             .stream()
                             .map(QuizOverview::new)
                             .toList();
    }
}
