package carlos.cardoso.gamification.entities;

import org.springframework.util.Assert;

import java.util.UUID;

public record QuestionId(UUID id) {
    public QuestionId() {
        this(UUID.randomUUID());
    }

    public QuestionId {
        Assert.notNull(id, "Id must not be null");
    }
}