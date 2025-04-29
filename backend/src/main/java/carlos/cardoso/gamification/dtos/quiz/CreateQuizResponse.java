package carlos.cardoso.gamification.dtos.quiz;

import carlos.cardoso.gamification.entities.Quiz;

public class CreateQuizResponse extends QuizOverview {
    public CreateQuizResponse(Quiz quiz) {
        super(quiz);
    }
}
