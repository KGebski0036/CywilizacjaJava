package pl.edu.ezse.Cywilizacja.Services.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.ezse.Cywilizacja.Database.IUserDAO;
import pl.edu.ezse.Cywilizacja.Model.User;
import pl.edu.ezse.Cywilizacja.Services.IAuteticationService;
import pl.edu.ezse.Cywilizacja.Sesion.SesionObject;

import javax.annotation.Resource;
import java.util.Optional;

public class AutenticationService implements IAuteticationService {

    @Autowired
    IUserDAO userDAO;

    @Resource
    SesionObject sessionObject;
    
    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userDAO.getUserByLogin(login);
        if(userBox.isPresent() &&
                userBox.get().getPassword()
                        .equals(DigestUtils.md5Hex(password))) {
            this.sessionObject.setUser(userBox.get());
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setUser(null);
    }

    @Override
    public void register(String login, String password) {
        Optional<User> userBox = this.userDAO.getUserByLogin(login);

        if(userBox.isPresent()) {
            return;
        }

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        this.userDAO.addUser(user);
    }
}
