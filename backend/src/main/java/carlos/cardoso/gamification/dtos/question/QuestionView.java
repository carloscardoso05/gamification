package carlos.cardoso.gamification.dtos.question;

import carlos.cardoso.gamification.dtos.answer.AnswerView;
import carlos.cardoso.gamification.entities.Difficulty;
import carlos.cardoso.gamification.entities.Question;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class QuestionView {
    private final UUID id;
    private final String text;
    private final Difficulty difficulty;
    private final List<AnswerView> answers;

    public QuestionView(Question question) {
        id = question.getId().id();
        text = question.getText();
        difficulty = question.getDifficulty();
        answers = question.getAnswers()
                          .stream()
                          .map(AnswerView::new)
                          .toList();
    }
}