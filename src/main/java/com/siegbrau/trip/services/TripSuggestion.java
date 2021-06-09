package com.siegbrau.trip.services;

import com.siegbrau.trip.model.TripInfo;
import com.siegbrau.trip.model.TripSuggested;
import org.springframework.stereotype.Service;

@Service
public interface TripSuggestion {
    TripSuggested suggest(TripInfo tripInfo);
}
