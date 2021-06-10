package com.siegbrau.trip.services.impl;

import com.siegbrau.trip.model.TripInfo;
import com.siegbrau.trip.model.TripSuggested;
import com.siegbrau.trip.services.TripSuggestion;
import com.siegbrau.trip.services.constants.Season;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_AUTUMN_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_FOOD_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_SPRING_AUTUMN_STUFF_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_SPRING_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_STUFF_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_SUMMER_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_SUMMER_STUFF_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_WINTER_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.DEFAULT_WINTER_STUFF_SET;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.LONG_JOURNEY_STUFF_SET_WITH_CAMPING;
import static com.siegbrau.trip.services.constants.DefaultSuggestionConstants.LONG_JOURNEY_STUFF_SET_WITH_NO_CAMPING;

@Service
public class TripDefaultSuggestionImpl implements TripSuggestion {

    @Override
    public TripSuggested suggest(TripInfo tripInfo) {
        TripSuggested tripSuggested = new TripSuggested(tripInfo);
        Season currentSeason = determineSeason(tripInfo);
        int durationInDays = determineDurationInDays(tripInfo);

        tripSuggested.setOtherRequiredStuff(setStuffBasedOnSeason(currentSeason));
        tripSuggested.setClothesList(setClothesBasedOnSeason(currentSeason));

        tripSuggested.getOtherRequiredStuff()
                     .putAll(setStuffBasedOnDuration(tripInfo, durationInDays));
        tripSuggested.setFoodList(new HashMap<>(DEFAULT_FOOD_SET));
        return forEachParticipant(tripSuggested, durationInDays);
    }

    private TripSuggested forEachParticipant(TripSuggested tripSuggested, int days) {
        if (tripSuggested.getParticipantNumber() == 1) {
            return tripSuggested;
        }
        tripSuggested.getFoodList().forEach((key, value) -> tripSuggested.getFoodList().replace(key,
                (int) value * tripSuggested.getParticipantNumber() * days));
        tripSuggested.getOtherRequiredStuff()
                     .forEach((key, value) -> tripSuggested.getOtherRequiredStuff().replace(key,
                             (int) value * tripSuggested.getParticipantNumber()));
        tripSuggested.getClothesList()
                     .forEach((key, value) -> tripSuggested.getClothesList().replace(key,
                             (int) value * tripSuggested.getParticipantNumber()));
        return tripSuggested;
    }

    private HashMap<String, Object> setStuffBasedOnSeason(Season season) {
        HashMap<String, Object> stuff = new HashMap<>(DEFAULT_STUFF_SET);
        switch (season) {
            case WINTER: {
                stuff.putAll(new HashMap<>(DEFAULT_WINTER_STUFF_SET));
                return stuff;
            }
            case SPRING:
            case AUTUMN: {
                stuff.putAll(new HashMap<>(DEFAULT_SPRING_AUTUMN_STUFF_SET));
                return stuff;
            }
            case SUMMER: {
                stuff.putAll(new HashMap<>(DEFAULT_SUMMER_STUFF_SET));
                return stuff;
            }
            default: {
                return stuff;
            }
        }
    }

    private HashMap<String, Object> setClothesBasedOnSeason(Season season) {
        switch (season) {
            case WINTER: {
                return new HashMap<>(DEFAULT_WINTER_SET);
            }
            case SPRING: {
                return new HashMap<>(DEFAULT_SPRING_SET);
            }
            case SUMMER: {
                return new HashMap<>(DEFAULT_SUMMER_SET);
            }
            case AUTUMN: {
                return new HashMap<>(DEFAULT_AUTUMN_SET);
            }
            default: {
                return new HashMap<>(DEFAULT_SET);
            }

        }
    }

    private HashMap<String, Object> setStuffBasedOnDuration(TripInfo tripInfo, int days) {
        if (days > 1) {
            return tripInfo.isCampingPlanned() ?
                    new HashMap<>(LONG_JOURNEY_STUFF_SET_WITH_CAMPING) :
                    new HashMap<>(LONG_JOURNEY_STUFF_SET_WITH_NO_CAMPING);
        } else {
            return new HashMap<>(LONG_JOURNEY_STUFF_SET_WITH_NO_CAMPING);
        }

    }

    private int determineDurationInDays(TripInfo tripInfo) {
        //        if no dates are specified, it calculates approximate values. Assume 1 full day = 48 km.
        //        0 is rounded to 1
        if (tripInfo.getStartDate() == null || tripInfo.getEndDate() == null) {
            return (int) (tripInfo.getDistanceKm() / 48) <= 0 ? 1 :
                    (int) (tripInfo.getDistanceKm() / 48);
        }
        return (int) ChronoUnit.DAYS.between(tripInfo.getStartDate(), tripInfo.getEndDate()) <= 0 ?
                1 : (int) ChronoUnit.DAYS.between(tripInfo.getStartDate(), tripInfo.getEndDate());
    }

    private Season determineSeason(TripInfo tripInfo) {
        if (tripInfo.getStartDate() == null) {
            return Season.UNDEFINED;
        }
        return Season.seasonForMonth(tripInfo.getStartDate().getMonthValue());
    }
}
