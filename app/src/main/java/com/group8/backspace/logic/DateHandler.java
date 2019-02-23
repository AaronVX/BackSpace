package com.group8.backspace.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class DateHandler {
    private Date departure;
    private Date arrival;

    public DateHandler(Date departure, Date arrival){
        this.departure = departure;
        this.arrival = arrival;
    }

    public String[] getStrings(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dates[] = { dateFormat.format(departure), dateFormat.format(arrival)};

        return dates;
    }

    public String getTravelTime(){
        long diff = arrival.getTime() - departure.getTime();
        String returnString = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) +" days";
        return returnString;
    }
}
