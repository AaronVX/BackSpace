package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;

public class CalculatePrice {
    private int ticketPrice;
    private int classPrice;

    public CalculatePrice(int flightNum, int classPrice){
        AccessFlights accessor =   new AccessFlights();
        Flight currFlight = accessor.getFlightByNum(flightNum);
        ticketPrice = currFlight.getTicketPrice();
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