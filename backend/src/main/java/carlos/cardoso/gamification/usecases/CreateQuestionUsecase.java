package carlos.cardoso.gamification.usecases;

import carlos.cardoso.gamification.annotations.UseCase;
import carlos.cardoso.gamification.dtos.question.CreateQuestionRequest;
import carlos.cardoso.gamification.dtos.question.CreateQuestionResponse;
import carlos.cardoso.gamification.entities.Answer;
import carlos.cardoso.gamification.entities.Question;
import carlos.cardoso.gamification.entities.Quiz;
import carlos.cardoso.gamification.entities.QuizId;
import carlos.cardoso.gamification.exceptions.ResourceNotFoundException;
import carlos.cardoso.gamification.repositories.QuestionRepository;
import carlos.cardoso.gamification.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class CreateQuestionUsecase {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public CreateQuestionResponse execute(QuizId quizId, CreateQuestionRequest request) {
        Quiz quiz = quizRepository.findById(quizId)
                                  .orElseThrow(() -> new ResourceNotFoundException(Quiz.class, quizId));

        List<Answer> answers = request.getAnswers()
                                      .stream()
                                      .map(dto -> new Answer(dto.getText(), dto.isCorrect()))
                                      .toList();

        Question question = new Question() {{
            setText(request.getText());
            setDifficulty(request.getDifficulty());
            setAnswers(answers);
            setQuiz(quiz);
        }};

        questionRepository.save(question);
        return new CreateQuestionResponse(question);
    }
}
