package carlos.cardoso.gamification.dtos.quiz;

import carlos.cardoso.gamification.entities.Quiz;

public class GetQuizByIdResponse extends QuizDetails{
    public GetQuizByIdResponse(Quiz quiz) {
        super(quiz);
    }
}
