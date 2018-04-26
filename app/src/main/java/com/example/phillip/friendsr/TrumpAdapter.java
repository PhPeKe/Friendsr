package com.example.phillip.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;

public class TrumpAdapter extends ArrayAdapter<Trump> {
    // Specifying adapter trumps to save array-list
    private ArrayList<Trump> trumps;

    // Constructor for Adapter
    public TrumpAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Trump> objects) {
        super(context, resource, objects);

        // Save passed array-list to local variable to pass it further to getView
        trumps = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // Handler for this trump
        Trump thistrump = trumps.get(position);

        // Set image and name by first getting the right reference and then setting properties
        // extracted from the array-list depending on the position
        TextView name = convertView.findViewById(R.id.name);
        name.setText(thistrump.getName());

        // Used step of img for overview reasons
        ImageView image = convertView.findViewById(R.id.image);
        Drawable img = getContext().getResources().getDrawable(thistrump.getDrawableId());
        image.setImageDrawable(img);

        // Return everything to the main activity
        return convertView;
    }

}
