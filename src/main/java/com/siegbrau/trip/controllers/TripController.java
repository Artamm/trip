package com.siegbrau.trip.controllers;

import com.siegbrau.trip.model.TripInfo;
import com.siegbrau.trip.services.TripSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for a web page
 */
@Controller
public class TripController {
    private final TripSuggestion tripSuggestion;

    @Autowired
    public TripController(TripSuggestion tripSuggestion) {
        this.tripSuggestion = tripSuggestion;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("trip", new TripInfo());
        return "index";
    }

    @PostMapping("/new")
    public String getTripSuggestion(@ModelAttribute("trip") TripInfo trip, Model model) {
        model.addAttribute("result", tripSuggestion.suggest(trip));
        return "result";
    }
}
