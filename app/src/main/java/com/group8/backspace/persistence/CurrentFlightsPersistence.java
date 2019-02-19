package com.group8.backspace.persistence;

import java.util.List;

import com.group8.backspace.objects.CurrentFlights;

public interface CurrentFlightsPersistence {
    List<CurrentFlights> getInfo();
}
