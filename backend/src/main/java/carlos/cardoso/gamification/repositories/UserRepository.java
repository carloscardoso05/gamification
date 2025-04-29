package carlos.cardoso.gamification.repositories;

import carlos.cardoso.gamification.entities.User;
import carlos.cardoso.gamification.entities.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByEmail(String email);
}
