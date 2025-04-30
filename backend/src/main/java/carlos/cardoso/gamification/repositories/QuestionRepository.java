package carlos.cardoso.gamification.repositories;

import carlos.cardoso.gamification.entities.Question;
import carlos.cardoso.gamification.entities.QuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, QuestionId> {
}
