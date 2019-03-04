package com.group8.backspace.presentation.PurchaseTicket;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;


public class DateHandler {
    private DateTime departure;
    private DateTime arrival;

    public DateHandler(DateTime departure, DateTime arrival){
        this.departure = departure;
        this.arrival = arrival;
    }

    public String[] getStrings(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] dates = { dateFormat.format(departure), dateFormat.format(arrival)};
        return dates;
    }

    public String getTravelTime(){
        long diff = arrival.getMillis() - departure.getMillis();
        String returnString = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) +" days";
        return returnString;
    }
}
