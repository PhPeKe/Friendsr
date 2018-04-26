package com.example.phillip.friendsr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Get selected Trump from intent
        Intent intent = getIntent();
        Trump retrievedTrump = (Trump) intent.getSerializableExtra("clicked_trump");

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
    }
}
