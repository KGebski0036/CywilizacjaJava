package pl.edu.ezse.Cywilizacja.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.ezse.Cywilizacja.Model.LvlsOfBuildings;
import pl.edu.ezse.Cywilizacja.Model.User;

import java.util.Optional;

public interface IUserLvlsOfBuildingsRepository extends JpaRepository<LvlsOfBuildings, Long> {
    Optional<LvlsOfBuildings> findLvlsOfBuildingsByUser(User user);
}
