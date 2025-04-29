package carlos.cardoso.gamification.dtos.answer;

import carlos.cardoso.gamification.entities.Answer;
import lombok.Getter;

@Getter
public class AnswerView {
    private  final String text;
    private final boolean isCorrect;

    public AnswerView(Answer answer) {
        this.text = answer.getText();
        this.isCorrect = answer.isCorrect();
    }
}
