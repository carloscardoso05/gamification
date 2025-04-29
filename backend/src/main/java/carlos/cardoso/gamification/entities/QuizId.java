package carlos.cardoso.gamification.entities;

import org.springframework.util.Assert;

import java.util.UUID;

public record QuizId(UUID id) {
    public QuizId() {
        this(UUID.randomUUID());
    }

    public QuizId {
        Assert.notNull(id, "Id must not be null");
    }
}
