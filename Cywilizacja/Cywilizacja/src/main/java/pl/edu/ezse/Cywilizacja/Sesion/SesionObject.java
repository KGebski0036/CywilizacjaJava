package pl.edu.ezse.Cywilizacja.Sesion;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.ezse.Cywilizacja.Model.User;

@Component
@SessionScope
public class SesionObject {
    private User user = null;

    public boolean isLogged() {
        return this.user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
