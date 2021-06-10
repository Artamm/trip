package com.siegbrau.trip.services;

import com.siegbrau.trip.model.TripInfo;
import com.siegbrau.trip.model.TripSuggested;
import com.siegbrau.trip.services.impl.TripDefaultSuggestionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_SPRING_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.LONG_JOURNEY_STUFF_SET_WITH_CAMPING;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.LONG_JOURNEY_STUFF_SET_WITH_NO_CAMPING;

class DefaultTripSuggestionImplTest {
    private TripSuggestion tripSuggestion = new TripDefaultSuggestionImpl();

    @Test
    void verifyNotNegativeQuantityIfDatesAreWrong() {
        TripInfo tripInfo =
                new TripInfo(100D, LocalDate.of(2021, 4, 4), LocalDate.of(2021, 3, 3), "somewhere",
                        4, true);
        TripSuggested tripSuggested = tripSuggestion.suggest(tripInfo);
        tripSuggested.getFoodList().forEach((k, v) -> Assertions.assertTrue((int) v > 0));
    }

    @Test
    void verifyLongTripStuffIsSet() {
        TripInfo tripInfo =
                new TripInfo(200D, null, null, "somewhere",
                        4, true);
        TripSuggested withCamping = tripSuggestion.suggest(tripInfo);
        LONG_JOURNEY_STUFF_SET_WITH_CAMPING.forEach((k, v) -> Assertions
                .assertTrue(withCamping.getOtherRequiredStuff().containsKey(k)));
        tripInfo =
                new TripInfo(200D, null, null, "somewhere",
                        4, false);
        TripSuggested noCamping = tripSuggestion.suggest(tripInfo);

        LONG_JOURNEY_STUFF_SET_WITH_NO_CAMPING.forEach(
                (k, v) -> Assertions.assertTrue(noCamping.getOtherRequiredStuff().containsKey(k)));
    }

    @Test
    void verifySeasonIsSetCorrect() {
        //        If date is specified
        TripInfo tripInfo =
                new TripInfo(100D, LocalDate.of(2021, 4, 4), LocalDate.of(2021, 5, 5), "somewhere",
                        4, true);
        TripSuggested springSeason = tripSuggestion.suggest(tripInfo);
        DEFAULT_SPRING_SET.forEach(
                (k, v) -> Assertions.assertTrue(springSeason.getClothesList().containsKey(k)));

        //        If no date
        tripInfo = new TripInfo(100D,null, null, "somewhere",
                4, true);

        TripSuggested defaultSeason = tripSuggestion.suggest(tripInfo);
        DEFAULT_SET.forEach(
                (k, v) -> Assertions.assertTrue(defaultSeason.getClothesList().containsKey(k)));
    }

}
