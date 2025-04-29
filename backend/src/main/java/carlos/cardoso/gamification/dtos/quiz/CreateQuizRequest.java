package carlos.cardoso.gamification.dtos.quiz;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateQuizRequest {
    @NotBlank
    private String title;
    @NotNull
    private String description;
}
