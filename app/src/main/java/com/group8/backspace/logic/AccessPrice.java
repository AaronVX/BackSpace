package com.group8.backspace.logic;
import com.group8.backspace.application.Services;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.PlanetPersistence;

import org.hsqldb.DatabaseURL;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class AccessPrice {
//    private int fuelUnitPrice;
    private int classDailyPrice;
    private int itemsDailyPrice;
    private Flight currFlight;
    private PlanetPersistence planetPersistence;
    private int duration;
    private int ticketPrice;
    private int extraExpense;
    private final int FUEL_PRICE = 2000;
//    private int prepaidDays;
//    private double distance;

//    public AccessPrice(Flight currFlight, int classPrice, int itemsPrice){
//
//        String origin = currFlight.getOrigin();
//        String destination = currFlight.getDestination();
//
//        // set total duration of the flight
//        DateTime departure = currFlight.getDeparture();
//        DateTime arrival = currFlight.getArrival();
//        this.duration = Days.daysBetween(departure.toLocalDate(), arrival.toLocalDate()).getDays();
//        this.prepaidDays = this.duration;
//
//        // set total distance
//        AccessPlanets accessPlanets = new AccessPlanets(Services.getPlanetPersistence());
//        Location originPlanet = accessPlanets.getPlanetByName(origin);
//        Location destinationPlanet = accessPlanets.getPlanetByName(destination);
//        this.distance =  Math.abs(Double.parseDouble(originPlanet.getDistance()) - Double.parseDouble(destinationPlanet.getDistance()));
//
//        // set basic prices
//        AccessItems accessItems = new AccessItems(Services.getItemPersistence());
//        this.fuelUnitPrice = accessItems.getItemByName("dark matter").getPrice();
//        this.classDailyPrice = classPrice;
//        this.itemsDailyPrice = itemsPrice;
//    }


//    public void setPrepaidPercentage(int percentage){
//        if (percentage > 100) {
//            this.prepaidDays = duration;
//        }
//        if (percentage <= 0) {
//            this.prepaidDays = 0;
//        }
//        else{
//            double multiplier = (double) percentage / 100;
//            this.prepaidDays = (int)(this.duration*multiplier);
//        }
//    }

    // Getters

//    public int getFuelPrice(){
//        return (int)(distance*fuelUnitPrice);
//    }
//
//    public int getClassPrice(){
//        return classDailyPrice*duration;
//    }

    public int getExtraExpense(){
        return extraExpense;
    }
    public int getTicketPrice(){
        return ticketPrice;
    }

    public int getTotalPrice(){
        return  ticketPrice+extraExpense;
    }
//
//    public int getTotalDuration(){return duration;}
//
//    public int getPrepaidDays(){return prepaidDays;}

    public AccessPrice(Flight currFlight, int classPrice, int itemsPrice, final PlanetPersistence planetPersistence){
        this.currFlight = currFlight;
        this.classDailyPrice = classPrice;
        this.itemsDailyPrice = itemsPrice;
        this.planetPersistence = planetPersistence;

    }

    public void calculatePrice(){
        String origin = currFlight.getOrigin();
        String destination = currFlight.getDestination();

        DateTime departure = currFlight.getDeparture();
        DateTime arrival = currFlight.getArrival();
        duration = Days.daysBetween(departure.toLocalDate(), arrival.toLocalDate()).getDays();

        extraExpense=(itemsDailyPrice+classDailyPrice)*duration;

        Location originPlanet = planetPersistence.getPlanetByName(origin);
        Location destinationPlanet = planetPersistence.getPlanetByName(destination);
        double distance =  Math.abs(Double.parseDouble(originPlanet.getDistance()) - Double.parseDouble(destinationPlanet.getDistance()));

        ticketPrice =(int) (distance*FUEL_PRICE);
    }
}
