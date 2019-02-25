package com.group8.backspace.objects;

public class Location {

    private String id;
    private String imgSrc;

    public Location(String id, String src) {
        this.id = id;
        this.imgSrc = src;
    }

    public String getId(){
        return this.id;
    }

    public String getImgSrc() {
        return imgSrc;
    }
}
