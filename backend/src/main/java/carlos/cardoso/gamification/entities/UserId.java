package carlos.cardoso.gamification.entities;

import org.springframework.util.Assert;

import java.util.UUID;

public record UserId(UUID id) {
    public UserId() {
        this(UUID.randomUUID());
    }

    public UserId {
        Assert.notNull(id, "Id must not be null");
    }
}