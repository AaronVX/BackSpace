package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;

public class BookingSession {

    private static final BookingSession ourInstance = new BookingSession();

    private Flight flight;
    private Location origin;
    private Location destination;
    private String travelClass;
    private AccessPrice prices;

    public BookingSession() {
        origin = null;
        flight = null;
        destination = null;
        travelClass = null;
        prices = null;
    }

    public static BookingSession getSession() {
        return ourInstance;
    }

    public void addflight( Flight flight ){this.flight=flight;}

    public void addOrigin( Location origin ){this.origin=origin;}

    public void addDestination( Location destination ){this.destination=destination;}

    public void addTravelClass( String travelClass ){this.travelClass=travelClass;}

    public void addAccessPrice( AccessPrice prices ){this.prices=prices;}

    public Flight getFlight(){return flight;}
    public Location getOrigin(){return origin;}
    public Location getDestination(){return destination;}
    public String getTravelClass(){return travelClass;}
    public AccessPrice getAccessPrice(){return prices;}
}
