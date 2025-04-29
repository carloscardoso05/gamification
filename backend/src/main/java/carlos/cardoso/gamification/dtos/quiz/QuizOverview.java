package carlos.cardoso.gamification.dtos.quiz;

import carlos.cardoso.gamification.dtos.user.UserView;
import carlos.cardoso.gamification.entities.Quiz;
import lombok.Getter;

import java.util.UUID;

@Getter
public class QuizOverview {
    private final UUID id;
    private final String title;
    private final String description;
    private final boolean isPublic;
    private final int questionsCount;
    private final UserView owner;

    public QuizOverview(Quiz quiz) {
        id = quiz.getId().id();
        title = quiz.getTitle();
        description = quiz.getDescription();
        isPublic = quiz.isPublic();
        questionsCount = quiz.getQuestions().size();
        owner = quiz.getOwner() != null ? new UserView(quiz.getOwner()) : null;
    }
}
