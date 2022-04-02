package pl.edu.ezse.Cywilizacja.Services.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import pl.edu.ezse.Cywilizacja.Database.IUsersResourcesInGameRepository;
import pl.edu.ezse.Cywilizacja.Database.IUserRepository;
import pl.edu.ezse.Cywilizacja.Model.User;
import pl.edu.ezse.Cywilizacja.Model.UserResoucesInGame;
import pl.edu.ezse.Cywilizacja.Services.IAuteticationService;
import pl.edu.ezse.Cywilizacja.Sesion.SesionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AutenticationService implements IAuteticationService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IUsersResourcesInGameRepository userResourcesRepository;

    @Resource
    SesionObject sessionObject;
    
    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userRepository.findUserByLogin(login);
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
    public Boolean register(String login, String password) {
        Optional<User> userBox = this.userRepository.findUserByLogin(login);

        if(userBox.isPresent()) {
            return false;
        }
        password = DigestUtils.md5Hex(password);
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        this.userRepository.save(user);

        UserResoucesInGame userResoucesInGame = new UserResoucesInGame();
        userResoucesInGame.setUser(user);
        userResourcesRepository.save(userResoucesInGame);
        Optional<UserResoucesInGame> userResouces = userResourcesRepository.findUserResoucesInGameByUser(user);
        user.setUserResoucesInGame(userResouces.get());
        return true;
    }
}
