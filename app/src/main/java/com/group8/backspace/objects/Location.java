package com.group8.backspace.objects;

public class Location {

    private String id;
    private int imgSrc;

    public Location(String id, int src) {
        this.id = id;
        this.imgSrc = src;
    }

    public String getId(){
        return this.id;
    }

    public int getImgSrc() {
        return imgSrc;
    }
}
