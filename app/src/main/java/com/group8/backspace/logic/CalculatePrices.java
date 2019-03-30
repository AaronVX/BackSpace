package com.group8.backspace.logic;

public class CalculatePrices {

    private final int FUEL_UNIT_PRICE = 3000;
    private int classDailyPrice;
    private int itemsDailyPrice;

    private int duration;
    private double totalDistance;
    private int prepaidDays;

    public CalculatePrices(double totalDistance, int duration,
                           int classDailyPrice, int itemsDailyPrice){
        this.totalDistance = totalDistance;
        this.duration = duration;
        this.prepaidDays = this.duration;
        this.classDailyPrice = classDailyPrice;
        this.itemsDailyPrice = itemsDailyPrice;
    }

    public void setPrepaidDays(int percentage){
        if (percentage > 100) {
            this.prepaidDays = duration;
        }
        if (percentage <= 0) {
            this.prepaidDays = 0;
        }
        else{
            double multiplier = (double) percentage / 100;
            this.prepaidDays = (int)(this.duration*multiplier);
        }
    }

    public int getPrepaidDays(){
        return prepaidDays;
    }

    // Calculate price dynamically
    public int calculateFuelPrice(){
        return (int)(totalDistance*FUEL_UNIT_PRICE);
    }

    public int calculateClassPrice(){
        return classDailyPrice*duration;
    }

    public int calculatePrepaidPrice(){
        return itemsDailyPrice*prepaidDays;
    }

    public int calculateTotalPrice(){
        return calculateFuelPrice() + calculateClassPrice() + calculatePrepaidPrice();
    }

//    public AccessPrice(Flight currFlight, int classPrice, int itemsPrice, final PlanetPersistence planetPersistence){
//        this.currFlight = currFlight;
//        this.classDailyPrice = classPrice;
//        this.itemsDailyPrice = itemsPrice;
//        this.planetPersistence = planetPersistence;
//    }
//
//    public void calculatePrice(){
//        String origin = currFlight.getOrigin();
//        String destination = currFlight.getDestination();
//
//        DateTime departure = currFlight.getDeparture();
//        DateTime arrival = currFlight.getArrival();
//        duration = Days.daysBetween(departure.toLocalDate(), arrival.toLocalDate()).getDays();
//
//        extraExpense=(itemsDailyPrice+classDailyPrice)*duration;
//
//        Location originPlanet = planetPersistence.getPlanetByName(origin);
//        Location destinationPlanet = planetPersistence.getPlanetByName(destination);
//        double distance =  Math.abs(Double.parseDouble(originPlanet.getDistance()) - Double.parseDouble(destinationPlanet.getDistance()));
//
//        ticketPrice =(int) (distance*FUEL_PRICE);
//    }

//    public int getExtraExpense(){
//        return extraExpense;
//    }
//
//    public int calculateTotalPrice(){
//        return  ticketPrice+extraExpense;
//    }

}

