package com.group8.backspace.logic;
import com.group8.backspace.objects.Flight;
import org.joda.time.DateTime;
import java.util.ArrayList;
import java.util.List;

public class AnalyseDates {

    final List<Flight> flights;

    public AnalyseDates(List<Flight> flights){
        this.flights = flights;
    }

    public ArrayList<DateTime> extractUniqueDepartures()
    {
        ArrayList<DateTime> dates = new ArrayList<DateTime>();

        for (Flight flight : flights) {
            DateTime date = flight.getDeparture();
            if (!dates.contains(date)) {
                dates.add(date);
            }
        }
        return dates;
    }


}