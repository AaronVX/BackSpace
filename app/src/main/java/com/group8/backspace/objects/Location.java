package com.group8.backspace.objects;

public enum Location {

    MERCURY ("mercury"),
    VENUS ("venus"),
    EARTH ("earth"),
    MOON ("moon"),
    MARS ("mars"),
    JUPITER ("jupiter"),
    SATURN ("saturn"),
    URANUS ("uranus"),
    NEPTUNE ("neptune");

    private final String name;

    Location(String name) {
        this.name = name;
    }


    public static Location getByName(String name) {
        Location[] locations = Location.values();
        for (Location location : locations) {
            if (location.name.equals(name)) {
                return location;
            }
        }
        return null;
    }
}
