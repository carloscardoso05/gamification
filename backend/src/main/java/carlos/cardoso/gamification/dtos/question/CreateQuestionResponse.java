package carlos.cardoso.gamification.dtos.question;

import carlos.cardoso.gamification.entities.Question;

public class CreateQuestionResponse extends QuestionView {
    public CreateQuestionResponse(Question question) {
        super(question);
    }
}
