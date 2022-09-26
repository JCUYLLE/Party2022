package be_buschop.ap2022.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller

public class Homecontroller {
    private final int myspecialnumber = 35;
    @GetMapping(value = {"/home", "/"})
    public String home (Model model){
        model.addAttribute("myspecialnumber",myspecialnumber);
        return "home";
    }

    @GetMapping("/about")
    public String about (){
        return "about";
    }
}
