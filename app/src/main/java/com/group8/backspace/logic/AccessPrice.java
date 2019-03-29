package com.group8.backspace.logic;
import com.group8.backspace.application.Services;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class AccessPrice {
    private int fuelUnitPrice;
    private int classDailyPrice;
    private int itemsDailyPrice;

    private int duration;
    private int prepaidDays;
    private double distance;

    public AccessPrice(Flight currFlight, int classPrice, int itemsPrice){

        String origin = currFlight.getOrigin();
        String destination = currFlight.getDestination();

        // set total duration of the flight
        DateTime departure = currFlight.getDeparture();
        DateTime arrival = currFlight.getArrival();
        this.duration = Days.daysBetween(departure.toLocalDate(), arrival.toLocalDate()).getDays();
        this.prepaidDays = this.duration;

        // set total distance
        AccessPlanets accessPlanets = new AccessPlanets(Services.getPlanetPersistence());
        Location originPlanet = accessPlanets.getPlanetByName(origin);
        Location destinationPlanet = accessPlanets.getPlanetByName(destination);
        this.distance =  Math.abs(Double.parseDouble(originPlanet.getDistance()) - Double.parseDouble(destinationPlanet.getDistance()));

        // set basic prices
        AccessItems accessItems = new AccessItems(Services.getItemPersistence());
        this.fuelUnitPrice = accessItems.getItemByName("dark matter").getPrice();
        this.classDailyPrice = classPrice;
        this.itemsDailyPrice = itemsPrice;
    }


    public void setPrepaidPercentage(int percentage){
        if (percentage > 100) {
            this.prepaidDays = duration;
        }
        if (percentage <= 0) {
            this.prepaidDays = 0;
        }
        else{
            double multiplier = (double) percentage / 100;
            this.prepaidDays = (int)(this.duration*multiplier);
        }
    }

    // Getters

    public int getFuelPrice(){
        return (int)(distance*fuelUnitPrice);
    }

    public int getClassPrice(){
        return classDailyPrice*duration;
    }

    public int getItemsPrice(){
        return itemsDailyPrice*prepaidDays;
    }

    public int getTotalPrice(){
        return  getFuelPrice()+getClassPrice()+getItemsPrice();
    }

    public int getTotalDuration(){return duration;}
    public int getPrepaidDays(){return prepaidDays;}
}
