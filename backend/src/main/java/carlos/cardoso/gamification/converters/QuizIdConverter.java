package carlos.cardoso.gamification.converters;

import carlos.cardoso.gamification.entities.QuizId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class QuizIdConverter implements Converter<String, QuizId> {
    @Override
    public QuizId convert(String source) {
        return new QuizId(UUID.fromString(source));
    }
}
