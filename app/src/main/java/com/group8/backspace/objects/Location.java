package com.group8.backspace.objects;

public class Location {

    private String id;
    private String imgSrc;
    private String years;
    private String minTemp;
    private String maxTemp;
    private String population;
    private String distance;
    private String description;
    private String shortDesc;

    public Location(String id, String src, String yrs, String min, String max, String pop, String dist, String desc, String shortDesc)
    {
        this.id = id;
        this.imgSrc = src;
        this.years = yrs;
        this.minTemp = min;
        this.maxTemp = max;
        this.population = pop;
        this.distance = dist;
        this.description = desc;
        this.shortDesc = shortDesc;
    }

    public String getShortDesc() { return this.shortDesc; }

    public String getId(){
        return this.id;
    }

    public String getImgSrc() { return imgSrc; }

    public String getYears() { return years; }

    public String getMin() { return minTemp; }

    public String getMax() { return maxTemp; }

    public String getPopulation() { return population; }

    public String getDistance(){ return distance; }

    public String getDescription() { return description; }
}
