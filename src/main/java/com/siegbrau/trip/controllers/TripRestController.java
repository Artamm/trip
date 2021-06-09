package com.siegbrau.trip.controllers;

import com.siegbrau.trip.model.TripInfo;
import com.siegbrau.trip.model.TripSuggested;
import com.siegbrau.trip.services.TripSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TripRestController {
    private final TripSuggestion tripSuggestion;

    @Autowired
    public TripRestController(TripSuggestion tripSuggestion) {
        this.tripSuggestion = tripSuggestion;
    }

    @PostMapping(value = "/trip/new", produces ="application/json")
    private TripSuggested getSuggestedInformation(@RequestBody TripInfo tripInfo) {
        return tripSuggestion.suggest(tripInfo);
    }
}
