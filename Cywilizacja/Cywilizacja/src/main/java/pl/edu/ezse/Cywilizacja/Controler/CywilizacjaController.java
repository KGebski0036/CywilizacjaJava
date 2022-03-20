package pl.edu.ezse.Cywilizacja.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.ezse.Cywilizacja.Sesion.SesionObject;

import javax.annotation.Resource;

@Controller
public class CywilizacjaController {

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

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
       return "redirect:/";
    }
}
