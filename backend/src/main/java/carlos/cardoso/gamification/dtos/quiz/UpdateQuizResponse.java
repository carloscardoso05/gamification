package carlos.cardoso.gamification.dtos.quiz;

import carlos.cardoso.gamification.entities.Quiz;

public class UpdateQuizResponse extends QuizOverview{
    public UpdateQuizResponse(Quiz quiz) {
        super(quiz);
    }
}
