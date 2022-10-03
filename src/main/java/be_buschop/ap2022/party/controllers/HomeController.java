package be_buschop.ap2022.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class HomeController {
    private final int mySpecialNumber = 35;
    private final String[] venuenames= {"Zillion","Carré","Cherrymoon"};
    @GetMapping(value = {"/", "/home", "/home/"})

    public String home(Model model) {
        model.addAttribute( "mySpecialNumber", mySpecialNumber );
        return "home";
    }

    @GetMapping(value = {"/venuelist", "/venuelist/"})

    public String venuelist(Model model){
        model.addAttribute("venuenames",venuenames);
        return "venuelist";
    }

    @GetMapping("/about")

    public String about(){
        return "about";
    }

    @GetMapping(value = {"/venuedetails/{venueName}"})
    public String venuedetails(Model model,
                               @PathVariable(required = false) String venueName){
        model.addAttribute("venueName",venueName);
        return "venuedetails";
    }
    @GetMapping("/pay")
    public String pay(Model model) {
        return "pay";
    }
}