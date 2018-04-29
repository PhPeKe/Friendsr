package com.example.phillip.friendsr;

import java.io.Serializable;

// Class Trump
public class Trump implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;
    private int likes = 0;

    // Constructor for a trump-object with name, biography and rating
    public Trump(String aName, String aBio, int aDrawableId) {
        this.name = aName;
        this.bio = aBio;
        this.drawableId = aDrawableId;
    }

    // Getter for private fields of trump
    public int getDrawableId() {
        return drawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    // Getter and setter for rating
    public float getRating() {
        return rating;
    }
    public void setRating(float aRating) {
        this.rating = aRating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int like) {
        this.likes = like;
    }

    public void raiseLikes() {
        this.likes += 1;
    }
}
