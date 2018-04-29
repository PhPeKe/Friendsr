package com.example.phillip.friendsr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    // Instantiate variable to hold the currently selected trumps name for dynamic key construction
    private String trumpName;
    private Trump retrievedTrump;
    private float rating;
    private TextView bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Get selected Trump from intent
        Intent intent = getIntent();
        retrievedTrump = (Trump) intent.getSerializableExtra("clicked_trump");

        // Store name in String for later
        trumpName = retrievedTrump.getName();

        // Now put in all the values:
        // Name
        TextView name = findViewById(R.id.name);
        name.setText(retrievedTrump.getName());

        // Image
        ImageView image = findViewById(R.id.image);
        Drawable img = this.getResources().getDrawable(retrievedTrump.getDrawableId());
        image.setImageDrawable(img);

        // Bio
        bio = findViewById(R.id.bio);
        bio.setText(retrievedTrump.getBio());

        // Rating-bar
        RatingBar ratingBar = findViewById(R.id.rating);

        // Get shared preferences
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        rating = prefs.getFloat("rating_" + trumpName, 1000);

        // Set rating if present
        if (rating != 1000) {
            ratingBar.setRating(rating);
        }

        // Connect rating bar with event-listener
        ratingBar.setOnRatingBarChangeListener(new OnRating());

    }

    private class OnRating implements RatingBar.OnRatingBarChangeListener {

        // Instantiate shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();

        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            // Save rating with a dynamically constructed key for each trump
            editor.putFloat("rating_" + trumpName, v);
            editor.apply();

            // Set rating in trump itself
            retrievedTrump.setRating(rating);
        }
    }

}
