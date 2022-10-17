package be_buschop.ap2022.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        model.addAttribute("venueNames",venuenames);
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
    public String pay(Model model){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        model.addAttribute("today",format.format(today));
        c.add(Calendar.DATE,30);
        Date paydate = c.getTime();
        model.addAttribute("paydate", format.format(paydate));
        return "pay";
    }
    @GetMapping({"/venuedetailsbyindex","/venuedetailsbyindex/","/venuedetailsbyindex/{venueindex}"})
    public String venuedetailsbyindex(Model model, @PathVariable(required = false) String venueindex){
        String venueTitle = "";
        if(venueindex !=null && Integer.parseInt(venueindex)%1 == 0 && Integer.parseInt(venueindex)>= 0 && Integer.parseInt(venueindex)< 5 )
        {
            //get venue data here
            venueTitle = venuenames[Integer.parseInt(venueindex)];
        }
        else
        {
            venueTitle = "no valid venue";
        }
        int prevIndex = Integer.parseInt(venueindex)-1;
        if(prevIndex<0){
            prevIndex = venuenames.length - 1;
        }

        int nextIndex = Integer.parseInt(venueindex)+1;
        if(nextIndex >4)
        {
            nextIndex = 0;
        }

        model.addAttribute("venueTitle",venueTitle);
        model.addAttribute("prevIndex", prevIndex);
        model.addAttribute("nextIndex", nextIndex);
        return "venuedetailsbyindex";
    }


}