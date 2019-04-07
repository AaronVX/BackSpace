package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.PlanetPersistence;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class AnalyseFlight {

    private PlanetPersistence planetPersistence;
    private Flight currFlight;

    private double distance;
    private int duration;

    public AnalyseFlight(Flight currFlight, final PlanetPersistence planetPersistence){
        this.planetPersistence = planetPersistence;
        this.currFlight = currFlight;
    }

    public void analyse(){
        String origin = currFlight.getOrigin();
        String destination = currFlight.getDestination();

        Location originPlanet = planetPersistence.getPlanetByName(origin);
        Location destinationPlanet = planetPersistence.getPlanetByName(destination);
        double sunToOrigin = Double.parseDouble(originPlanet.getDistance());
        double sunToDestination = Double.parseDouble(destinationPlanet.getDistance());
        distance =  Math.abs(sunToOrigin - sunToDestination );

        DateTime departure = currFlight.getDeparture();
        DateTime arrival = currFlight.getArrival();
        duration = Days.daysBetween(departure.toLocalDate(), arrival.toLocalDate()).getDays();
    }

    public double getDistance() { return distance; }

    public int getDuration() { return duration; }
}