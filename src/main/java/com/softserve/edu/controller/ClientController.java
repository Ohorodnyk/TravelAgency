package com.softserve.edu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.edu.service.ClientService;
import com.softserve.edu.service.CountryService;
import com.softserve.edu.service.HotelService;
import com.softserve.edu.service.VisaService;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private VisaService visaService;

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = { "/clientForm" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "clientForm";
    }

    @RequestMapping(value = { "/clientForm1" }, method = RequestMethod.GET)
    public String showForm1(ModelMap model) {
        return "clientForm1";
    }

    @RequestMapping(value = "/clientStatistic", method = RequestMethod.POST)
    public ModelAndView getCountByCountry(@RequestParam String firstName, @RequestParam String lastName,
            ModelMap model) {

        model.addAttribute("list", countryService.findVisited(firstName, lastName));
        model.addAttribute("set", clientService.find(firstName, lastName).getVisas());
        return new ModelAndView("clientStatistic", model);

    }

    @RequestMapping(value = "/reserveHotel", method = RequestMethod.POST)
    public ModelAndView reserveHotel(@RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String country, @RequestParam String city, @RequestParam String date, ModelMap model)
            throws ParseException {
        Date utilDate = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        utilDate = dateFormatter.parse(date);
        model.addAttribute("set", visaService.findValid(firstName, lastName, country));
        model.addAttribute("list", hotelService.findFree(city, utilDate));
        return new ModelAndView("reserveHotel", model);
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullException(NullPointerException ex) {
        return "nullPointerError";
    }

    @ExceptionHandler(ParseException.class)
    public String handleParseException(ParseException ex) {
        return "parseError";
    }

}
