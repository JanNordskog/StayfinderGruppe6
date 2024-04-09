package no.ntnu.IDATA2306.Group6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController {

    @GetMapping(value = "/")
    public String index(){
        return "index";

    }

    @PostMapping("/greeting")
    public String userRegistration(@ModelAttribute User user){
        System.out.println(user.toString());
        return "index";
    }
    
}