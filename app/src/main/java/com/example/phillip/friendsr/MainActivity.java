package com.example.phillip.friendsr;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Trump> trumps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTrump("Smug Trump", "Is overall extremely happy with himself", "smug");
        addTrump("Angry Trump", "Thinks about who he will fire today", "angry");
        addTrump("Arrogant Trump", "Is a few million dollars better than you", "arrogant");
        addTrump("Astonished Trump", "Just realized he won the elections", "astonished");
        addTrump("Sad Trump", "Just heard he can't let Mexico pay for the wall", "bewildered");
        addTrump("Focused Trump", "How many fingers do I have?", "focused");
        addTrump("Incredulous Trump", "Doesn't believe a word you just said to him", "incredulous");
        addTrump("Fashionable Trump", "Feels a little lofty today", "fashionable_lofty");
        addTrump("Happy Trump", "Is extremely happy with himself today", "mirthful");
        addTrump("Sleepy Trump", "Had a long afternoon at the white house", "sleepy");
        addTrump("Cool Trump", "Cooler than ice", "cool");
        addTrump("Cheeky Trump", "Just thought of a joke", "cheeky");


        System.out.println("-----------PRINT----------");
        System.out.println(trumps.get(0).getBio());
        System.out.println("-----------PRINT----------");

    }

    private void addTrump(String name, String bio, String picture) {
        trumps.add(new Trump(name, bio, this.getResources().getIdentifier(picture, "id", getPackageName())));
    }


}

