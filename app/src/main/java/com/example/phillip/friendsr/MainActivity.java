package com.example.phillip.friendsr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    // Make empty array list to which the trumps can be added later
    ArrayList<Trump> trumps = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add all trumps to array-list
        addTrump("Smug Trump", "Just fired you", "smug");
        addTrump("Angry Trump", "Thinks about who he will fire today", "angry");
        addTrump("Arrogant Trump", "Is a few million dollars better than you", "arrogant");
        addTrump("Astonished Trump", "Just realized he won the elections", "astonished");
        addTrump("Incredulous Trump", "Doesn't believe a word you just said to him", "incrodulous");
        addTrump("Fashionable Trump", "Feels a little lofty today", "lofty_fashionable");
        addTrump("Sad Trump", "Just heard he can't let Mexico pay for the wall", "bewildered");
        addTrump("Focused Trump", "How many fingers do I have?", "focused");
        addTrump("Happy Trump", "Is extremely happy with himself today", "mirthful");
        addTrump("Sleepy Trump", "Had a long afternoon at the white house", "sleepy");
        addTrump("Cool Trump", "Cooler than ice", "cool");
        addTrump("Cheeky Trump", "Just thought of a joke", "cheeky");

        // Instantiate adapter to fill the main View with Trumps
        TrumpAdapter adapter = new TrumpAdapter(this, R.layout.grid_item, trumps);

        // Save reference to grid-view
        GridView grid = findViewById(R.id.grid);

        // Pair adapter with grid-view
        grid.setAdapter(adapter);

        System.out.println("-----------PRINT----------");
        System.out.println(trumps.get(9).getDrawableId());
        System.out.println("-----------PRINT----------");

    }

    // Function to add Trumps faster without unnecessary code
    private void addTrump(String name, String bio, String picture) {
        trumps.add(new Trump(name, bio, this.getResources().getIdentifier(picture, "drawable", getPackageName())));
    }


}

