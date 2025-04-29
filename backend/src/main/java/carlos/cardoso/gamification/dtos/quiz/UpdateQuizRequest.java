package carlos.cardoso.gamification.dtos.quiz;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateQuizRequest {
    @Nullable
    @Size(min = 1)
    private String title;
    @Nullable
    private String description;
    @Nullable
    private Boolean isPublic;
}
