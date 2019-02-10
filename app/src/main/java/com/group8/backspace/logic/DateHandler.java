package com.group8.backspace.logic;

import com.group8.backspace.objects.Location;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import static org.threeten.bp.temporal.ChronoUnit.DAYS;


public class DateHandler {
    private LocalDate leaveDate;
    private LocalDate arriveDate;

    public DateHandler(CalendarDay departure, CalendarDay arrival){
        this.leaveDate = departure.getDate();
        this.arriveDate = arrival.getDate();
    }

    public String[] getStrings(){
        DateTimeFormatter dateF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dates[] = { leaveDate.format(dateF), arriveDate.format(dateF)};

        return dates;
    }

    public String getTravelTime(){
        long daysBetween = DAYS.between(leaveDate, arriveDate);
        String returnString = Long.toString(daysBetween)+" days";
        return returnString;
    }
}
