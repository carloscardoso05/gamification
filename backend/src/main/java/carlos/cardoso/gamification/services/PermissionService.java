package carlos.cardoso.gamification.services;

import carlos.cardoso.gamification.entities.*;
import carlos.cardoso.gamification.repositories.QuestionRepository;
import carlos.cardoso.gamification.repositories.QuizRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public PermissionService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();

    }

    public boolean isOwner(QuizId quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElse(null);
        User currentUser = getCurrentUser();
        if (quiz == null) {
            return false;
        }
        return quiz.getOwner().getId().equals(currentUser.getId());
    }

    public boolean isOwner(QuestionId questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question == null) {
            return false;
        }
        User currentUser = getCurrentUser();
        return question.getQuiz().getOwner().getId().equals(currentUser.getId());
    }

    public boolean isVisible(QuizId quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElse(null);
        if (quiz == null) {
            return false;
        }
        return isOwner(quizId) || quiz.isPublic();
    }
}
