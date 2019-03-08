package com.group8.backspace.logic;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class CalculatePrice {
    private int ticketPrice;
    private int classPrice;

    public CalculatePrice(int flightNum, int classPrice, int itemsPrice){
        AccessFlights accessor =  new AccessFlights();

        Flight currFlight = accessor.getFlightByID(flightNum);
        String origin = currFlight.getOrigin();
        String destination = currFlight.getDestination();
        DateTime departure = currFlight.getDeparture();
        DateTime arrival = currFlight.getArrival();
        int duration = Days.daysBetween(departure.toLocalDate(), arrival.toLocalDate()).getDays();

        AccessPlanets accessPlanets = new AccessPlanets();
        Location originPlanet = accessPlanets.getPlanetByName(origin);
        Location destinationPlanet = accessPlanets.getPlanetByName(destination);
        double distance =  Math.abs(Double.parseDouble(originPlanet.getDistance()) - Double.parseDouble(destinationPlanet.getDistance()));

        AccessItems accessItems = new AccessItems();
        int fuelPrice = accessItems.getItemByName("dark matter").getPrice();
        ticketPrice = (int)(distance*fuelPrice);
        this.classPrice = (classPrice+itemsPrice)*duration;
    }


    public int getTicketPrice(){return ticketPrice;}

    public int getClassPrice(){return classPrice;}

    public int getTotalPrice(){return  ticketPrice + classPrice;}


}
