package pl.edu.ezse.Cywilizacja.Database.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.ezse.Cywilizacja.Database.IUserDAO;
import pl.edu.ezse.Cywilizacja.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDAO implements IUserDAO {
    @Autowired
    Connection connection;

    @Override
    public List<User> getUsers() {
        List<User> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tuser";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));

                result.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        try {
            String sql = "SELECT * FROM tuser WHERE login = ?";

            PreparedStatement ps = this.connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, login);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));

                return Optional.of(user);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO tuser VALUES (NULL, ?, ?, ?, ?)";

            PreparedStatement ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            rs.next();
            user.setId(rs.getLong(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        try {
            String sql = "SELECT * FROM tuser WHERE id = ?";

            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));

                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
