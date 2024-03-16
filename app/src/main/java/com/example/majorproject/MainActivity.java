package com.example.majorproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MotionLayout motionLayout = findViewById(R.id.main);

        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                // Transition started
                Log.d("MotionLayout", "Transition started.");
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
                // Transition in progress
                Log.d("MotionLayout", "Transition in progress. Progress: " + progress);
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                // Transition completed, navigate to ListViewActivity after a slight delay
                Log.d("MotionLayout", "Transition completed. Navigating to ListViewActivity.");
                new Handler().postDelayed(() -> navigateToListViewActivity(), 0); // Set delay to 0 for testing
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
                // Transition trigger
                Log.d("MotionLayout", "Transition trigger. Trigger ID: " + triggerId + ", Positive: " + positive + ", Progress: " + progress);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void navigateToListViewActivity() {
        // Add the code to navigate to ListViewActivity here
        Log.d("Navigation", "Navigating to ListViewActivity.");
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
        // Optional: finish the current activity if you don't want to go back to it
        // finish();
    }
}
