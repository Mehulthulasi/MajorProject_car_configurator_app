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

        // Find TextViews and Buttons by their IDs
        TextView textView6 = findViewById(R.id.textView6);
        TextView textView8 = findViewById(R.id.textView8);
        Button button = findViewById(R.id.button);

        TextView textView9 = findViewById(R.id.textView9);
        TextView textView11 = findViewById(R.id.textView11);
        Button button1 = findViewById(R.id.button1);

        TextView textView12 = findViewById(R.id.textView12);
        TextView textView14 = findViewById(R.id.textView14);
        Button button2 = findViewById(R.id.button2);

        // Set OnClickListener for the first button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to start the next activity
                Intent nextIntent = new Intent(sales.this, end.class);
                // Pass the text from the TextViews to the next activity
                nextIntent.putExtra("textView1", textView6.getText().toString());
                nextIntent.putExtra("textView2", textView8.getText().toString());
                // Start the next activity
                startActivity(nextIntent);

                // Add the car description to the database
                if (carDescription != null) {
                    String key = mDatabase.child("sales").push().getKey();
                    mDatabase.child("sales").child(key).child("carDescription").setValue(carDescription);
                    mDatabase.child("sales").child(key).child("dealerName").setValue(textView8.getText().toString());
                }
            }
        });

        // Set OnClickListener for the second button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to start the next activity
                Intent nextIntent = new Intent(sales.this, end.class);
                // Pass the text from the TextViews to the next activity
                nextIntent.putExtra("textView1", textView9.getText().toString());
                nextIntent.putExtra("textView2", textView11.getText().toString());
                // Start the next activity
                startActivity(nextIntent);

                // Add the car description to the database
                if (carDescription != null) {
                    String key = mDatabase.child("sales").push().getKey();
                    mDatabase.child("sales").child(key).child("carDescription").setValue(textView11.getText().toString());
                }
            }
        });

        // Set OnClickListener for the third button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to start the next activity
                Intent nextIntent = new Intent(sales.this, end.class);
                // Pass the text from the TextViews to the next activity
                nextIntent.putExtra("textView1", textView12.getText().toString());
                nextIntent.putExtra("textView2", textView14.getText().toString());
                // Start the next activity
                startActivity(nextIntent);

                // Add the car description to the database
                if (carDescription != null) {
                    String key = mDatabase.child("sales").push().getKey();
                    mDatabase.child("sales").child(key).child("carDescription").setValue(carDescription);
                    mDatabase.child("sales").child(key).child("carDescription").setValue(textView14.getText().toString());

                }
            }
        });
    }
}
