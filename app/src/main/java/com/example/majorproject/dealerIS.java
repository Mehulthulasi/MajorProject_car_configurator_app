package com.example.majorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class dealerIS extends AppCompatActivity {
    private ArrayList<String> selectedCarImages;
    private String carDescr;
    private String carIntr;
    private String carEng;
    private String carWh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_is);

        // Get the passed data from the Intent
        Intent intent = getIntent();
        if (intent != null) {
            // Retrieve the arrays of image resources
            selectedCarImages = intent.getStringArrayListExtra("selectedCarImages");

            // Retrieve the descriptions
            carDescr = intent.getStringExtra("carDescription");
            carIntr = intent.getStringExtra("carInterior");
            carEng = intent.getStringExtra("carEngine");
            carWh = intent.getStringExtra("carWheels");

            // Display descriptions
            displayDescription(carDescr, R.id.textView);
            displayDescription(carIntr, R.id.textView2);
            displayDescription(carEng, R.id.textView3);
            displayDescription(carWh, R.id.textView4);
        }

        // Display images
        displayImages(selectedCarImages, new int[]{R.id.imageView, R.id.imageView2, R.id.imageView3, R.id.imageView4});

        // Find the button
        Button button = findViewById(R.id.button8);
        // Set OnClickListener to handle button click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create Intent to start the next activity
                Intent nextIntent = new Intent(dealerIS.this, sales.class);
                // Pass the selected car images along with other descriptions to the next activity
                nextIntent.putStringArrayListExtra("selectedCarImages", selectedCarImages);
                nextIntent.putExtra("carDescription", carDescr);
                nextIntent.putExtra("carInterior", carIntr);
                nextIntent.putExtra("carEngine", carEng);
                nextIntent.putExtra("carWheels", carWh);
                startActivity(nextIntent);
            }
        });
    }

    // Method to display images in the specified ImageViews
    private void displayImages(ArrayList<String> imageResources, int[] imageViewIds) {
        if (imageResources != null && !imageResources.isEmpty() && imageViewIds != null && imageResources.size() == imageViewIds.length) {
            for (int i = 0; i < imageViewIds.length; i++) {
                ImageView imageView = findViewById(imageViewIds[i]);
                Picasso.get().load(imageResources.get(i)).into(imageView);
            }
        }
    }

    // Method to display description in the specified TextView
    private void displayDescription(String description, int textViewId) {
        if (description != null) {
            // Find the TextView in the layout
            TextView textView = findViewById(textViewId);
            // Set the description to the TextView
            textView.setText(description);
        }
    }
}
