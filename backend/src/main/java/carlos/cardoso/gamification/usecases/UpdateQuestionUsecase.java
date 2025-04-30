package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.dtos.question.CreateQuestionResponse;
import carlos.cardoso.gamification.dtos.question.UpdateQuestionRequest;
import carlos.cardoso.gamification.dtos.question.UpdateQuestionResponse;
import carlos.cardoso.gamification.entities.*;
import carlos.cardoso.gamification.exceptions.ResourceNotFoundException;
import carlos.cardoso.gamification.repositories.QuestionRepository;
import carlos.cardoso.gamification.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class UpdateQuestionUsecase {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public UpdateQuestionResponse execute(QuestionId questionId, UpdateQuestionRequest request) {
        Question question = questionRepository.findById(questionId)
                                              .orElseThrow(() -> new ResourceNotFoundException(Question.class, questionId));

        if (request.getDifficulty() != null) {
            question.setDifficulty(request.getDifficulty());
        }

        if (request.getText() != null) {
            question.setText(request.getText());
        }

        if (request.getAnswers() != null) {
            List<Answer> answers = request.getAnswers()
                                          .stream()
                                          .map(dto -> new Answer(dto.getText(), dto.isCorrect()))
                                          .toList();
            question.setAnswers(answers);
        }

        questionRepository.save(question);
        return new UpdateQuestionResponse(question);
    }
}
