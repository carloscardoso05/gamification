package carlos.cardoso.gamification.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Quiz {
    @EmbeddedId
    private QuizId id;

    @NotBlank
    private String title;

    private boolean isPublic;

    @NotNull
    private String description;

    @OneToMany(mappedBy = "quiz")
    @NotNull
    private List<Question> questions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    public Quiz() {
        this.id = new QuizId();
    }
}
