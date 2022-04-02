package pl.edu.ezse.Cywilizacja.Model;

import javax.persistence.*;

@Entity
@Table(name = "uzytkownicy")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

    @OneToOne()
    private UserResoucesInGame userResoucesInGame;

    public User() {
    }

    public User(String login, String password, UserResoucesInGame userResoucesInGame) {
        this.login = login;
        this.password = password;
        this.userResoucesInGame = userResoucesInGame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResoucesInGame getUserResoucesInGame() {
        return userResoucesInGame;
    }

    public void setUserResoucesInGame(UserResoucesInGame userResoucesInGame) {
        this.userResoucesInGame = userResoucesInGame;
    }
}
