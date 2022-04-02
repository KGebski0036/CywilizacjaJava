package pl.edu.ezse.Cywilizacja.Database;

import pl.edu.ezse.Cywilizacja.Model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<User> getUsers();
    Optional<User> findUserByLogin(String login);
    void addUser(User user);
    User getUserById(int id);
}
