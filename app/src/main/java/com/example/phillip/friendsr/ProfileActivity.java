package com.example.phillip.friendsr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    // Instantiate variable to hold the currently selected trumps name for dynamic key construction
    private String trumpName;
    private Trump retrievedTrump;
    private float rating;
    private int likes;
    private Button likeButton;

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
        TextView bio = findViewById(R.id.bio);
        bio.setText(retrievedTrump.getBio());

        // Rating-bar
        RatingBar ratingBar = findViewById(R.id.rating);

        // Get shared preferences
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        rating = prefs.getFloat("rating_" + trumpName, 1000);
        likes = prefs.getInt("likes_" + trumpName, 0);

        // Save likes from shared preferences in Trump object
        retrievedTrump.setLikes(likes);

        // Set rating if present
        if (rating != 1000) {
            ratingBar.setRating(rating);
        }

        // Set Like-Button Text
        likeButton = findViewById(R.id.like);

        // Set text if likes is already present in shared preferences
        likeButton.setText("LIKE (" + String.valueOf(retrievedTrump.getLikes()) + ")");


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

    public void likeThis (final View view) {
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();

        // Raise likes in Trump-object
        retrievedTrump.raiseLikes();

        // Put current number of likes in shared preferences
        editor.putInt("likes_" + trumpName, retrievedTrump.getLikes());
        editor.apply();

        // Set likes on button-text
        likeButton.setText("LIKE (" + String.valueOf(retrievedTrump.getLikes()) + ")");

        System.out.println(retrievedTrump.getLikes());
    }
}
