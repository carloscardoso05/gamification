package carlos.cardoso.gamification.dtos.quiz;

import carlos.cardoso.gamification.dtos.question.QuestionView;
import carlos.cardoso.gamification.entities.Quiz;
import lombok.Getter;

import java.util.List;

@Getter
public class QuizDetails extends QuizOverview {
    private final List<QuestionView> questions;

    public QuizDetails(Quiz quiz) {
        super(quiz);
        this.questions = quiz.getQuestions().stream()
                             .map(QuestionView::new)
                             .toList();
    }
}
