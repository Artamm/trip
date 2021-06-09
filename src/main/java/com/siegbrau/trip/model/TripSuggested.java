package com.siegbrau.trip.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

/**
 * Suggested stuff for the current trip
 */
@Getter
@Setter
@NoArgsConstructor
@JsonRootName("result")
public class TripSuggested extends TripInfo {
    private static final long serialVersionUID = 5286498632356746169L;
    @JsonProperty
    private HashMap<String, Object> foodList;
    @JsonProperty
    private HashMap<String, Object> clothesList;
    @JsonProperty
    private HashMap<String, Object> otherRequiredStuff;

    public TripSuggested(TripInfo trip) {
        super(trip.getDistanceKm(), trip.getStartDate(), trip.getEndDate(),
                trip.getEndDestination(), trip.getParticipantNumber(), trip.isCampingPlanned());
    }

}
