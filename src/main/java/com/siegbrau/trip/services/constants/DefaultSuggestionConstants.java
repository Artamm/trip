package com.siegbrau.trip.services.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Class of constants for TripDefaultSuggestionImpl
 */
public class DefaultSuggestionConstants {
    //    Clothes sets
    public static final HashMap<String, Object> DEFAULT_WINTER_SET = new HashMap<>(
            Map.of("winter hat", 1,
                    "scarf", 1,
                    "pair of gloves", 1,
                    "pair of warm socks", 1,
                    "winter jacket", 1,
                    "winter sweater", 1,
                    "trousers", 1,
                    "a pair of boots", 1));

    public static final HashMap<String, Object> DEFAULT_SPRING_SET =
            new HashMap<>(Map.of("cap", 1,
                    "sunglasses", 1,
                    "coat", 1,
                    "pair of socks", 1,
                    "trousers", 1,
                    "a pair of sneakers", 1));

    public static final HashMap<String, Object> DEFAULT_SUMMER_SET = new HashMap<>(
            Map.of("cap", 1,
                    "sunglasses", 1,
                    "t-shirt", 1,
                    "shorts", 1,
                    "a pair of sandals", 1));

    public static final HashMap<String, Object> DEFAULT_AUTUMN_SET = new HashMap<>(
            Map.of("cap", 1,
                    "sunglasses", 1,
                    "coat", 1,
                    " pair of socks", 1,
                    "trousers", 1,
                    "a pair of sneakers", 1));

    public static final HashMap<String, Object> DEFAULT_SET = new HashMap<>(
            Map.of("scarf", 1,
                    "coat", 1,
                    "shirt", 1,
                    " pair of socks", 1,
                    "trousers", 1,
                    "a pair of sneakers", 1));

    //   food sets
    public static final HashMap<String, Object> DEFAULT_FOOD_SET = new HashMap<>(
            Map.of("bottle of water", 2,
                    "sandwich", 3,
                    "snacks for dog", 3,
                    "biscuits/other snacks", 2));

    //    Other stuff set

    public static final HashMap<String, Object> DEFAULT_STUFF_SET = new HashMap<>(
            Map.of("phone", 1,
                    "wallet", 1,
                    "mask", 1,
                    "disinfectant", 1,
                    "first aid kit", 1));

    public static final HashMap<String, Object> DEFAULT_WINTER_STUFF_SET = new HashMap<>(
            Map.of("thermos", 1));

    public static final HashMap<String, Object> DEFAULT_SPRING_AUTUMN_STUFF_SET = new HashMap<>(
            Map.of("umbrella", 1));

    public static final HashMap<String, Object> DEFAULT_SUMMER_STUFF_SET = new HashMap<>(
            Map.of("swimsuit", 1));

    //    Long journey sets
    public static final HashMap<String, Object> LONG_JOURNEY_STUFF_SET_WITH_CAMPING = new HashMap<>(
            Map.of("tent", 1,
                    "sleeping bag", 1,
                    "pillow", 1,
                    "lighter", 1,
                    "flashlight", 1));
    public static final HashMap<String, Object> LONG_JOURNEY_STUFF_SET_WITH_NO_CAMPING =
            new HashMap<>(
                    Map.of("documents", 1,
                            "pyjama", 1));

    DefaultSuggestionConstants() {
        throw new IllegalStateException("Utility class");
    }
}
