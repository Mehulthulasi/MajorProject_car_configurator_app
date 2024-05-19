package com.example.majorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class dealerIS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_is);

        // Get the intent that started this activity
        Intent intent = getIntent();

        // Retrieve the data passed from the previous activity
        int[] selectedCarImages = intent.getIntArrayExtra("selectedCarImages");
        int[] selectedInteriorImages = intent.getIntArrayExtra("selectedInteriorImages");
        int[] selectedEngineImages = intent.getIntArrayExtra("selectedEngineImages");
        int[] selectedWheelsImages = intent.getIntArrayExtra("selectedWheelsImages");

        String carDescription = intent.getStringExtra("carDescription");
        String carInterior = intent.getStringExtra("carInterior");
        String carEngine = intent.getStringExtra("carEngine");
        String carWheels = intent.getStringExtra("carWheels");

        // Set views with received data
        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);

        if (selectedCarImages != null && selectedCarImages.length > 0) {
            imageView.setImageResource(selectedCarImages[0]);
        }
        if (selectedInteriorImages != null && selectedInteriorImages.length > 0) {
            imageView2.setImageResource(selectedInteriorImages[0]);
        }
        if (selectedEngineImages != null && selectedEngineImages.length > 0) {
            imageView3.setImageResource(selectedEngineImages[0]);
        }
        if (selectedWheelsImages != null && selectedWheelsImages.length > 0) {
            imageView4.setImageResource(selectedWheelsImages[0]);
        }

        textView.setText(carDescription);
        textView2.setText(carInterior);
        textView3.setText(carEngine);
        textView4.setText(carWheels);
        textView5.setText("Additional information if needed");

        // Find the button by its id
        Button selectButton = findViewById(R.id.dealer);

        // Set OnClickListener to the button
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to start the sales activity
                Intent salesIntent = new Intent(dealerIS.this, sales.class);
                // Pass the necessary data as extras to the sales activity
                salesIntent.putExtra("carDescription", carDescription);
                salesIntent.putExtra("carInterior", carInterior);
                salesIntent.putExtra("carEngine", carEngine);
                salesIntent.putExtra("carWheels", carWheels);
                // Pass the image resource ID as an extra
                salesIntent.putExtra("selectedCarImage", selectedCarImages[0]);
                // Start the sales activity
                startActivity(salesIntent);
            }
        });
    }
}
