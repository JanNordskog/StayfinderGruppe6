package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import no.ntnu.IDATA2306.Group6.Entity.User;

@Controller
public class indexController {

    @GetMapping(value = "/")
    public String index() {
        return "index";

    }

    @PostMapping("/greeting")
    public String userRegistration(@ModelAttribute User user) {
        System.out.println(user.toString());
        return "index";
    }

}