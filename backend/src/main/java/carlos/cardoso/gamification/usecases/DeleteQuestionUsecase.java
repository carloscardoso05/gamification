package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.entities.Question;
import carlos.cardoso.gamification.entities.QuestionId;
import carlos.cardoso.gamification.exceptions.ResourceNotFoundException;
import carlos.cardoso.gamification.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteQuestionUsecase {
    private final QuestionRepository questionRepository;

    public void execute(QuestionId questionId) {
        questionRepository.findById(questionId)
                          .orElseThrow(() -> new ResourceNotFoundException(Question.class, questionId));
        questionRepository.deleteById(questionId);
    }
}
