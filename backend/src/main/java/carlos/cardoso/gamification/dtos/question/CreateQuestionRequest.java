package carlos.cardoso.gamification.dtos.question;

import carlos.cardoso.gamification.dtos.answer.CreateAnswerRequest;
import carlos.cardoso.gamification.entities.Difficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateQuestionRequest {
    @NotBlank
    private String text;
    @NotNull
    private Difficulty difficulty;
    @NotNull
    @Size(min = 4, max = 4)
    private List<CreateAnswerRequest> answers;
}
