package pl.edu.ezse.Cywilizacja.Controler;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.ezse.Cywilizacja.Services.IAuteticationService;
import pl.edu.ezse.Cywilizacja.Services.Implementations.AutenticationService;
import pl.edu.ezse.Cywilizacja.Sesion.SesionObject;
import pl.edu.ezse.Cywilizacja.Validation.ValidateRegisterUser;

import javax.annotation.Resource;
import javax.validation.ValidationException;

@Controller
public class CywilizacjaController {

    @Autowired
    IAuteticationService auteticationService;
    @Resource
    SesionObject sessionObject;

    @GetMapping("/")
    public String getIndex(){
       return "index";
   }
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String getLogin(){
        return "Login";
    }
    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String getRegister(){
        return "Register";
    }

    @RequestMapping (value = "/Main_game", method = RequestMethod.GET)
    public String getMainGame(Model model)
    {
        model.addAttribute("user", sessionObject.getUser());
        return sessionObject.isLogged() ? "Main_game" : "index";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password)
    {
       if(!sessionObject.isLogged()){
           auteticationService.authenticate(login,password);
       }
       if(sessionObject.isLogged()){
           return "redirect:/Main_game";
       }else {
           return "redirect:/Login";
       }
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String register(@RequestParam String login, @RequestParam String password)
    {
        try {
            ValidateRegisterUser.validateLogin(login);
            ValidateRegisterUser.validatePassword(password);
        }catch (ValidationException e){
            return "redirect:/Register";
        }
        if (auteticationService.register(login, password)){
            return login(login, password);
        }
        return "redirect:/Register";
    }

}
