package com.softserve.edu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.edu.service.HotelService;

@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = { "/hotelForm" }, method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        return "hotelForm";
    }

    @RequestMapping(value = { "/hotelForm2" }, method = RequestMethod.GET)
    public String showForm2(ModelMap model) {
        return "hotelForm2";
    }

    @RequestMapping(value = { "/hotelForm3" }, method = RequestMethod.GET)
    public String showForm3(ModelMap model) {
        return "hotelForm3";
    }

    @RequestMapping(value = { "/hotelForm4" }, method = RequestMethod.GET)
    public String showForm4(ModelMap model) {
        return "hotelForm4";
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.POST)
    public ModelAndView getByCity(@RequestParam String city, ModelMap model) {

        return new ModelAndView("hotels", "set", new HashSet<>(hotelService.findHotels(city)));

    }

    @RequestMapping(value = "/freeRooms", method = RequestMethod.POST)
    public ModelAndView countOfFreeRooms(@RequestParam String hotel, @RequestParam String date, ModelMap model)
            throws ParseException {

        Date utilDate = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        utilDate = dateFormatter.parse(date);
        model.addAttribute("date", date);
        model.addAttribute("count", hotelService.findCountOfFreeRooms(hotel, utilDate));
        return new ModelAndView("freeRooms", model);

    }

    @RequestMapping(value = "/avaliableHotels", method = RequestMethod.POST)

    public ModelAndView avaliableByCityAndDate(@RequestParam String city, @RequestParam String date, ModelMap model)
            throws ParseException {
        Date utilDate = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        utilDate = dateFormatter.parse(date);
        model.addAttribute("date", date);
        model.addAttribute("list", hotelService.findFree(city, utilDate));
        return new ModelAndView("avaliableHotels", model);

    }

    @RequestMapping(value = "/hotelStatistic", method = RequestMethod.POST)
    public ModelAndView hotelStatistic(@RequestParam String hotel, ModelMap model) {
        model.addAttribute("hotelName", hotel);
        model.addAttribute("avgTimeOfBooking", hotelService.averageTimeOfBooking(hotel));
        model.addAttribute("countOfClients", hotelService.findCountOfClients(hotel));
        return new ModelAndView("hotelStatistic", model);
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
