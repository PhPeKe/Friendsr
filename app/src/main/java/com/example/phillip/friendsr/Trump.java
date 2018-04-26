package com.example.phillip.friendsr;

import java.io.Serializable;


public class Trump implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;

    public Trump(String aName, String aBio, int aDrawableId) {
        this.name = aName;
        this.bio = aBio;
        this.drawableId = aDrawableId;
    }
    public void setRating(float aRating) {
        this.rating = aRating;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public float getRating() {
        return rating;
    }
}
