package carlos.cardoso.gamification.converters;

import carlos.cardoso.gamification.entities.QuestionId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class QuestionIdConverter implements Converter<String, QuestionId> {
    @Override
    public QuestionId convert(String source) {
        return new QuestionId(UUID.fromString(source));
    }
}
