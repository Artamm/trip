package com.siegbrau.trip.services.constants;

import java.util.Arrays;
import java.util.List;

public enum Season {
    WINTER(Arrays.asList(11, 12, 1, 2)),
    SPRING(Arrays.asList(3, 4)),
    SUMMER(Arrays.asList(5, 6, 7, 8)),
    AUTUMN(Arrays.asList(9, 10)),
    UNDEFINED(Arrays.asList(0));

    Season(List<Integer> months) {
        this.monthsList = months;
    }

    private List<Integer> monthsList;

    public boolean inSeason(int month) {
        return this.monthsList
                .contains(month);  // if months are 0 based, then insert +1 before the )
    }

    public static Season seasonForMonth(int month) {
        for (Season s : Season.values()) {
            if (s.inSeason(month)) {
                return s;
            }
        }
        return UNDEFINED;
    }
}
