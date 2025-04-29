package carlos.cardoso.gamification.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Answer {
    @NotBlank
    private String text;
    private boolean isCorrect;
}
