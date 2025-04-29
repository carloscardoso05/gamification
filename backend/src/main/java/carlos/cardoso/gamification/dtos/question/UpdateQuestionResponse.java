package carlos.cardoso.gamification.dtos.question;

import carlos.cardoso.gamification.entities.Question;

public class UpdateQuestionResponse extends QuestionView {
    public UpdateQuestionResponse(Question question) {
        super(question);
    }
}
