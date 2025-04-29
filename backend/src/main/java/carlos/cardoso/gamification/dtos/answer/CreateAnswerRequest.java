package carlos.cardoso.gamification.dtos.answer;

import lombok.Getter;

@Getter
public class CreateAnswerRequest {
    private String text;
    private boolean isCorrect;
}
