package carlos.cardoso.gamification.repositories;

import carlos.cardoso.gamification.entities.Quiz;
import carlos.cardoso.gamification.entities.QuizId;
import carlos.cardoso.gamification.entities.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, QuizId> {
    List<Quiz> findAllByOwnerId(UserId userId);

    @Query("select quiz from Quiz quiz where quiz.isPublic = true or quiz.owner.id = :userId")
    List<Quiz> findAllVisibleToUser(UserId userId);

    @Query("select quiz from Quiz quiz where quiz.id = :quizId and (quiz.isPublic = true or quiz.owner.id = :userId)")
    Optional<Quiz> findVisibleById(QuizId quizId, UserId userId);
}
