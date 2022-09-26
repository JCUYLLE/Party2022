package be_buschop.ap2022.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {
    @GetMapping(value = {"/home", "/"})
    public String home (){
        return "home";
    }

    @GetMapping("/about")
    public String about (){
        return "about";
    }
}
