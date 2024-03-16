package com.example.majorproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;

public class lexusIS extends AppCompatActivity {

    private int currentImageIndex = 0;
    private int currentSecondImageIndex = 0;
    private int currentThirdImageIndex = 0;
    private int[] imageResources = {R.drawable.is, R.drawable.is2, R.drawable.is3, R.drawable.is4, R.drawable.is5};
    private int[] redCarImages = {R.drawable.isb1, R.drawable.isb2, R.drawable.isb3,R.drawable.isb4,R.drawable.isb5};
    private int[] whiteCarImages = {R.drawable.isr1, R.drawable.isr2, R.drawable.isr3,R.drawable.isr4,R.drawable.isr5};
    private final int[] interiorblack = {R.drawable.isinblc1, R.drawable.isinblc2};
    private int[] interiorbrown = {R.drawable.isinbro1, R.drawable.isinbro2};
    private int[] interiored = {R.drawable.isinred1, R.drawable.isinred2};
    private int[] engine = {R.drawable.is300, R.drawable.is350, R.drawable.isf};

    private int[] currentCarImages;
    private int[] currentInteriorImages;
    private int[] currentengineImages;

    private ImageView imageView;
    private ImageView secondImageView;
    private ImageView thirdImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lexus_is);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.middleImage);
        secondImageView = findViewById(R.id.secondImage);
        thirdImageView = findViewById(R.id.thirdImage);


        ImageButton secondButton = findViewById(R.id.secondButton);
        ImageButton myButton = findViewById(R.id.myButton);
        ImageButton thirdButton = findViewById(R.id.thirdButton);
        ImageButton fourthButton = findViewById(R.id.fourthButton);
        ImageButton fifthButton = findViewById(R.id.fifthButton);
        ImageButton sixthButton = findViewById(R.id.sixthButton);
        ImageButton seventhButton = findViewById(R.id.seventhButton);
        ImageButton eighthButton = findViewById(R.id.eighthButton);
        ImageButton ninthButton = findViewById(R.id.ninthButton);
        ImageButton tenthButton = findViewById(R.id.tenthButton);
        ImageButton eleventhButton = findViewById(R.id.eleventhButton);
        ImageButton twelfthButton = findViewById(R.id.twelfthButton);
        ImageButton thirteenthButton = findViewById(R.id.thirteenButton);
        ImageButton fourteenthButton = findViewById(R.id.fourteenthButton);
        ImageButton fifteenthButton = findViewById(R.id.fifteenthButton);
        ImageButton sixteenthButton = findViewById(R.id.sixteenthButton);

        // Your other initialization code...

        // Set click listener for next image (first set)
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNextImage();
            }
        });

        // Set click listener for previous image (first set)
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPreviousImage();
            }
        });
        // Set click listener for third button (Red car image)
        // Set click listener for third button (Red car image) - update first image view
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCarImages = null;  // Set to null to use the default images
                updateImageView();
            }
        });

// Set click listener for fourth button (White car image) - update first image view
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCarImages = redCarImages;
                currentImageIndex = 0;  // Reset index when switching cars
                updateImageView();
                updateCarDescription("IS F SPORT");
            }
        });

// Set click listener for fifth button (Black car image) - update first image view
        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCarImages = whiteCarImages;
                currentImageIndex = 0;  // Reset index when switching cars
                updateThirdImageView();
                updateCarDescription("IS 500 F SPORT PERFORMANCE");
            }
        });

// Set click listener for sixth button (Next activity) - pass selected image to dealer activity
        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] selectedImages;
                if (currentCarImages == redCarImages) {
                    selectedImages = redCarImages;
                } else if (currentCarImages == whiteCarImages) {
                    selectedImages = whiteCarImages;
                } else {
                    // Default to imageResources
                    selectedImages = imageResources;
                }

                // Check if there are selected images
                if (selectedImages != null && selectedImages.length > 0) {
                    // Pass the first image of the selected color to the next activity
                    int selectedImage = selectedImages[0];
                    Intent intent = new Intent(lexusIS.this, dealerIS.class);
                    intent.putExtra("selectedImage", selectedImage);
                    startActivity(intent);
                } else {
                    // Handle if no images are selected
                    Toast.makeText(getApplicationContext(), "No images selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

// Set click listener for ninth button (Red car image) - update second image view
        ninthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInteriorImages = null;  // Set to null to use the default images
                updateSecondImageView();
            }
        });

// Set click listener for tenth button (White car image) - update second image view
        tenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInteriorImages = interiorbrown;
                currentSecondImageIndex = 0;  // Reset index when switching cars
                updateSecondImageView();
                updateCarDescription("IS F SPORT");
            }
        });

// Set click listener for eleventh button (Black car image) - update second image view
        eleventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInteriorImages = interiored;
                currentSecondImageIndex = 0;  // Reset index when switching cars
                updateSecondImageView();
                updateCarDescription("IS 500 F SPORT PERFORMANCE");
            }
        });

// Set click listener for fourteenth button (Red car image) - update third image view
        fourteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentengineImages = null;  // Set to null to use the default images
                updateThirdImageView();
            }
        });

// Set click listener for fifteenth button (White car image) - update third image view
        fifteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCarImages = redCarImages;
                currentImageIndex = 0;  // Reset index when switching cars
                updateThirdImageView();
                updateCarDescription("IS F SPORT");
            }
        });

// Set click listener for sixteenth button (Black car image) - update third image view
        sixteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCarImages = whiteCarImages;
                currentImageIndex = 0;  // Reset index when switching cars
                updateThirdImageView();
                updateCarDescription("IS 500 F SPORT PERFORMANCE");
            }
        });

// Set click listener for seventh button (Left for second set of images)
        seventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPreviousSecondImage();
            }
        });

// Set click listener for eighth button (Right for second set of images)
        eighthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNextSecondImage();
            }
        });

// Set click listener for twelfth button (Left for third set of images)
        twelfthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPreviousThirdImage();
            }
        });

// Set click listener for thirteenth button (Right for third set of images)
        thirteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNextThirdImage();
            }
        });


        // Your other click listeners...

        // Initial image display
        updateImageView();
        updateSecondImageView();
        updateThirdImageView();
    }

    // Method to show the next image (first set)
    private void showNextImage() {
        if (currentCarImages != null) {
            currentImageIndex = (currentImageIndex + 1) % currentCarImages.length;
        } else {
            currentImageIndex = (currentImageIndex + 1) % imageResources.length;
        }
        updateImageView();
    }

    // Method to show the previous image (first set)
    private void showPreviousImage() {
        if (currentCarImages != null) {
            currentImageIndex = (currentImageIndex - 1 + currentCarImages.length) % currentCarImages.length;
        } else {
            currentImageIndex = (currentImageIndex - 1 + imageResources.length) % imageResources.length;
        }
        updateImageView();
    }

    // Method to show the next image for the second set
    private void showNextSecondImage() {
        currentSecondImageIndex = (currentSecondImageIndex + 1) % interiorblack.length;
        updateSecondImageView();
    }

    // Method to show the previous image for the second set
    private void showPreviousSecondImage() {
        currentSecondImageIndex = (currentSecondImageIndex - 1 + interiorblack.length) % interiorblack.length;
        updateSecondImageView();
    }
    // Method to show the next image for the third set
    private void showNextThirdImage() {
        currentThirdImageIndex = (currentThirdImageIndex + 1) % engine.length;
        updateThirdImageView();
    }

    // Method to show the previous image for the third set
    private void showPreviousThirdImage() {
        currentThirdImageIndex = (currentThirdImageIndex - 1 + engine.length) % engine.length;
        updateThirdImageView();
    }

    // Method to update the first ImageView with the current image
    // Method to update the ImageView with the current image
    // Method to update the ImageView with the current image
    private void updateImageView() {
        if (currentCarImages != null && currentImageIndex >= 0 && currentImageIndex < currentCarImages.length) {
            imageView.setImageResource(currentCarImages[currentImageIndex]);
            // Change to your desired description
        } else if (currentCarImages == null && currentImageIndex >= 0 && currentImageIndex < imageResources.length) {
            imageView.setImageResource(imageResources[currentImageIndex]);
            updateCarDescription("THE IS LINE");
        }
    }

    // Method to update the car description text view
    private void updateCarDescription(String description) {
        TextView carDescriptionTextView = findViewById(R.id.carDescription);
        if (carDescriptionTextView != null) {
            carDescriptionTextView.setVisibility(View.VISIBLE);
            carDescriptionTextView.setText(description);
        }
    }






    // Method to update the second ImageView with the current image
    private void updateSecondImageView() {
        if (currentInteriorImages != null && currentSecondImageIndex>= 0 && currentSecondImageIndex < currentInteriorImages.length) {
            secondImageView.setImageResource(currentInteriorImages[currentSecondImageIndex]);
        } else if (currentSecondImageIndex >= 0 && currentSecondImageIndex < interiorblack.length) {
            secondImageView.setImageResource(interiorblack[currentSecondImageIndex]);
        }
    }


    private void updateThirdImageView() {
        if (currentengineImages != null && currentThirdImageIndex>= 0 && currentThirdImageIndex < currentengineImages.length) {
            thirdImageView.setImageResource(engine[currentThirdImageIndex]);
        } else if (currentThirdImageIndex >= 0 && currentThirdImageIndex < engine.length) {
            thirdImageView.setImageResource(engine[currentThirdImageIndex]);
        }
    }


    // Your other methods...

}
