package pl.edu.ezse.Cywilizacja.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CywilizacjaController {
   @GetMapping("/")
    public String getIndex(){
       return "index";
   }
    @GetMapping("/Login")
    public String getLogin(){
        return "Login";
    }
    @GetMapping("/Register")
    public String getRegister(){
        return "Register";
    }
}
