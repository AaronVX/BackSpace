package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;

public class CalculatePrice {
    private int ticketPrice;
    private int classPrice;

    public CalculatePrice(int flightNum, int classPrice){
        AccessFlights accessor =   new AccessFlights();
        Flight currFlight = accessor.getFlightByID(flightNum);
        String origin = currFlight.getOrigin();
        String destination = currFlight.getDestination();

        AccessPlanets accessPlanets = new AccessPlanets();
        Location originPlanet = accessPlanets.getPlanetByName(origin);
        Location destinationPlanet = accessPlanets.getPlanetByName(destination);

        double distance = Math.abs(Double.parseDouble(originPlanet.getDistance()) - Double.parseDouble(destinationPlanet.getDistance()));

        ticketPrice = (int)distance*10000;
        this.classPrice = classPrice;
    }


    public int getTicketPrice(){return ticketPrice;}

    public int getClassPrice(){return classPrice;}

    public int getTotalPrice(){return  ticketPrice + classPrice;}

    public void applyCoupon()
    {
        ticketPrice *= 0.9;
    }

}
