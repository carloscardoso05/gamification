package carlos.cardoso.gamification.dtos.question;

import carlos.cardoso.gamification.dtos.answer.CreateAnswerRequest;
import carlos.cardoso.gamification.entities.Difficulty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

@Getter
public class UpdateQuestionRequest {
    @Nullable
    private String text;
    @Nullable
    private Difficulty difficulty;
    @Nullable
    @Size(min = 4, max = 4)
    private List<CreateAnswerRequest> answers;
}
