package com.example.majorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sales extends AppCompatActivity {

    // Reference to the Firebase Realtime Database
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        // Initialize the Firebase database reference
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Get the intent that started this activity
        Intent intent = getIntent();

        // Retrieve the image resource ID and description passed from the previous activity
        int selectedCarImage = intent.getIntExtra("selectedCarImage", 0);
        String carDescription = intent.getStringExtra("carDescription");

        // Find the ImageView and TextView by their IDs
        ImageView imageView = findViewById(R.id.imageView9);
        TextView descriptionTextView = findViewById(R.id.textView6);

        // Set the image resource to the ImageView and set the description to the TextView
        if (selectedCarImage != 0) {
            imageView.setImageResource(selectedCarImage);
        }
        if (carDescription != null) {
            descriptionTextView.setText(carDescription);
        }

        // Find the button by its ID
        Button nextButton = findViewById(R.id.button);

        // Set OnClickListener to the button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to start the next activity
                Intent nextIntent = new Intent(sales.this, end.class);
                // Start the next activity
                startActivity(nextIntent);

                // Add the car description to the database
                if (carDescription != null) {
                    String key = mDatabase.child("sales").push().getKey();
                    mDatabase.child("sales").child(key).child("carDescription").setValue(carDescription);
                }
            }
        });
    }
}
