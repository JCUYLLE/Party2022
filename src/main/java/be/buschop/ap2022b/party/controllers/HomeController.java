package be.buschop.ap2022b.party.controllers;


import be.thomasmore.party.model.Venue;
import be.buschop.ap2022b.party.repositories.VenueRepository;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

    @Controller
    public class HomeController {
    private final int mySpecialNumber = 35;

    private final String [] venuenames = {"Carré", "Zillion", "Cherrymoon", "Boccaccio", "Carat"};

    private final Venue[] venues ={
         new Venue("Cue Breda","https://cuebreda.nl/"),
         new Venue("Thunderdome", "https://www.thunderdome.com/en/"),
         new Venue("Dominator", "https://www.dominatorfestival.nl/"),
    };

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping(value = {"/", "/home", "/home/"})
    public String home (Model model){
        model.addAttribute("mySpecialNumber",mySpecialNumber);
        return "home";
    }

    @GetMapping(value = {"/errors", "/errors/"})
    public String error (){

        return "error";
    }


    @GetMapping("/pay")
    public String pay(Model model){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);

        Boolean weekend = false;
        if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY )
        {
            weekend = true;
        }


        c.add(Calendar.DATE,5);
        Date paydate = c.getTime();



        model.addAttribute("paydate", format.format(paydate));
        model.addAttribute("weekend",weekend);
        return "pay";
    }

    @GetMapping("/about")     //Requesthandler @getMapping
    public String about (){
        return "about";
    }

    @GetMapping("/venuelist")
    public String venuelist (Model model){
        Iterable<be.buschop.ap2022b.party.model.Venue> venues = venueRepository.findAll();
        model.addAttribute("venues",venues);
        return "venuelist";
    }

    @GetMapping({"/venuedetails","/venuedetails/","/venuedetails/{venuename}"})
    public String venuedetails(Model model, @PathVariable(required = false) String venuename){
        model.addAttribute("venuename",venuename);
        return "venuedetails";
    }
    @GetMapping({"/artistList",})
    public String artistList(Model model, @PathVariable(required = false) String artists){
        model.addAttribute("artists", artists);
        return "artistList";
    }
    @GetMapping({"/venuedetailsbyid","/venuedetailsbyid/","/venuedetailsbyid/{venueid}"})
    public String venuedetailsbyid(Model model, @PathVariable(required = false) String venueid){

        Optional oVenue = null;
        Venue venue = null;
        int venueCount = 0;

        venueCount = (int) venueRepository.count();

        oVenue = venueRepository.findById(Integer.parseInt(venueid));
        if(oVenue.isPresent()){
            venue = (Venue) oVenue.get();
        }

        int prevId = Integer.parseInt(venueid)-1;
        if(prevId<1){
            prevId = venueCount;
        }

        int nextId = Integer.parseInt(venueid)+1;
        if(nextId > venueCount)
        {
            nextId = 1;
        }

        model.addAttribute("venue", venue);
        model.addAttribute("prevIndex", prevId);
        model.addAttribute("nextIndex", nextId);
        return "venuedetailsbyid";
    }

    @GetMapping({"/venuedetailsbyindex","/venuedetailsbyindex/","/venuedetailsbyindex/{venueindex}"})
    public String venuedetailsbyindex(Model model, @PathVariable(required = false) String venueindex){
        String venueTitle = "";
        Venue venue = null;

        if(venueindex !=null && Integer.parseInt(venueindex)%1 == 0 && Integer.parseInt(venueindex)>= 0 && Integer.parseInt(venueindex)< venues.length )
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
        model.addAttribute("venue", venue);
        model.addAttribute("prevIndex", prevIndex);
        model.addAttribute("nextIndex", nextIndex);
        return "venuedetailsbyindex";
    }

}