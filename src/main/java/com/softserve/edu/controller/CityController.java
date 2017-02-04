package com.softserve.edu.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.edu.service.CityService;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public ModelAndView getAll() {
        return new ModelAndView("cities", "set", new HashSet<>(cityService.getAll()));
    }

}
