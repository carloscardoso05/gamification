package carlos.cardoso.gamification.entities;

import carlos.cardoso.gamification.Util;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Question {
    @EmbeddedId
    private QuestionId id;

    @NotBlank
    private String text;

    @NotNull
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    @NotNull
    @JsonIgnore
    private Quiz quiz;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "question_answers", joinColumns = @JoinColumn(name = "question_id"))
    @NotNull
    @Size(min = 4, max = 4)
    private List<Answer> answers = new ArrayList<>();

    public Answer getCorrectAnswer() {
        return Util.findFirstWhere(answers, Answer::isCorrect)
                   .orElseThrow(() -> new IllegalStateException("The correct answer was not found. There must be exactly one correct answer."));
    }

    public Question() {
        this.id = new QuestionId();
    }
}
