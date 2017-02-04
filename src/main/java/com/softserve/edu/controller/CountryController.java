package com.softserve.edu.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.edu.service.CountryService;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public ModelAndView getAll() {
        return new ModelAndView("countries", "set", new HashSet<>(countryService.getAll()));
    }

}
