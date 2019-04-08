package com.group8.backspace.logic;
import com.group8.backspace.objects.Flight;
import org.joda.time.DateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnalyseDates {

    final List<Flight> flights;

    public AnalyseDates(List<Flight> flights){
        this.flights = flights;
    }

    public ArrayList<DateTime> getUniqueDepartures()
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

    public ArrayList<Flight> getFlightsForDeparture(int year, int mounth, int day)
    {
        ArrayList<Flight> similarFlights = new ArrayList<Flight>();
        DateTime date;
        for (Flight flight : flights) {
            date = flight.getDeparture();
            if (date.getYear() == year && date.getMonthOfYear() == mounth
                    && date.getDayOfMonth() == day) {
                similarFlights.add(flight);
            }
        }
        return similarFlights;
    }


}