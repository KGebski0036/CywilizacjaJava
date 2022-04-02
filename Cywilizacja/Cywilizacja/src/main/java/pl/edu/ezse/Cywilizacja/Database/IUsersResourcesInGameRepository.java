package pl.edu.ezse.Cywilizacja.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ezse.Cywilizacja.Model.User;
import pl.edu.ezse.Cywilizacja.Model.UserResoucesInGame;

import java.util.Optional;

@Repository
public interface IUsersResourcesInGameRepository extends JpaRepository<UserResoucesInGame, Long> {
    Optional<UserResoucesInGame> findUserResoucesInGameByUser(User user);
}
