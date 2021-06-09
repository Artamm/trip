package com.siegbrau.trip.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Information which is filled by user
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripInfo implements Serializable {
    private static final long serialVersionUID = 2327745031745212664L;
    @JsonProperty("distance")
    private double distanceKm = 1;
    @JsonProperty("start")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonProperty("end")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @JsonProperty("destination")
    private String endDestination;
    @JsonProperty("participants")
    private int participantNumber = 1;
    @JsonProperty("camping")
    private boolean isCampingPlanned;
}
