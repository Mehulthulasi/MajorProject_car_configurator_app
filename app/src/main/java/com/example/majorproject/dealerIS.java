package com.example.majorproject;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dealerIS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dealer_is);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the passed image resource ID from the Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("selectedImage")) {
            int selectedImageResource = intent.getIntExtra("selectedImage", 0);

            // Find the ImageView in the layout
            ImageView imageView = findViewById(R.id.imageView);

            // Set the image resource to the ImageView
            imageView.setImageResource(selectedImageResource);
        }


    }
}
