package com.example.phillip.friendsr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;

public class MainActivity extends Activity {

    // Make empty array list to which the trumps can be added later
    private ArrayList<Trump> trumps = new ArrayList<>();
    private GridView grid;
    private TrumpAdapter adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add all trumps to array-list via addTrump method, "\n" for aesthetic reasons
        addTrump("Smug \nTrump", "Just fired you", "smug");
        addTrump("Angry \nTrump", "Thinks about who he will fire today", "angry");
        addTrump("Arrogant \nTrump", "Is a few million dollars better than you", "arrogant");
        addTrump("Astonished \nTrump", "Just realized he won the elections", "astonished");
        addTrump("Incredulous \nTrump", "Doesn't believe a word you just said to him", "incrodulous");
        addTrump("Fashionable \nTrump", "Feels a little lofty today", "lofty_fashionable");
        addTrump("Sad \nTrump", "Just heard he can't let Mexico pay for the wall", "bewildered");
        addTrump("Focused \nTrump", "How many fingers do I have?", "focused");
        addTrump("Happy \nTrump", "Is extremely happy with himself today", "mirthful");
        addTrump("Sleepy \nTrump", "Had a long afternoon at the white house", "sleepy");
        addTrump("Cool \nTrump", "Cooler than refrigerated diet-coke", "cool");
        addTrump("Cheeky \nTrump", "Just thought of a joke", "cheeky");

        // Instantiate adapter to fill the main View with Trumps
        adapter = new TrumpAdapter(this, R.layout.grid_item, trumps);

        // Save reference to grid-view
        grid = findViewById(R.id.grid);

        // Pair adapter with grid-view
        grid.setAdapter(adapter);

        // Connect grid-view to
        grid.setOnItemClickListener(new GridItemClickListener());


    }

    // Function to add Trumps faster without unnecessary code
    private void addTrump(String name, String bio, String picture) {
        trumps.add(new Trump(name, bio, this.getResources().getIdentifier(picture, "drawable", getPackageName())));
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            // Retrieve appropriate trump
            Trump clicked_trump = (Trump) adapterView.getItemAtPosition(i);

            // Instantiate Intent
            intent = new Intent(MainActivity.this, ProfileActivity.class);

            // Pass selected trump to intent
            intent.putExtra("clicked_trump", clicked_trump);

            // Start activity
            startActivity(intent);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Hi","Hallo");
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


    }


}

