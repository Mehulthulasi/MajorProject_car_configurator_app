package com.example.majorproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private int currentFourthImageIndex = 0;
    private int[] imageResources = {R.drawable.is, R.drawable.is2, R.drawable.is3, R.drawable.is4, R.drawable.is5};
    private int[] redCarImages = {R.drawable.isb1, R.drawable.isb2, R.drawable.isb3,R.drawable.isb4,R.drawable.isb5};
    private int[] whiteCarImages = {R.drawable.isr1, R.drawable.isr2, R.drawable.isr3,R.drawable.isr4,R.drawable.isr5};
    private final int[] interiorblack = {R.drawable.isinblc1, R.drawable.isinblc2};
    private int[] interiorbrown = {R.drawable.isinbro1, R.drawable.isinbro2};
    private int[] interiored = {R.drawable.isinred1, R.drawable.isinred2};
    private int[] engine = {R.drawable.is300};
    private int[] engine1 = {R.drawable.is350};
    private int[] engine2 = { R.drawable.isf};
    private int[] wheels1 = { R.drawable.iswh1,R.drawable.iswh1side};
    private int[] wheels2 = { R.drawable.iswh2,R.drawable.iswh2side};
    private int[] wheels3 = { R.drawable.iswh3,R.drawable.iswh3side};
    private int[] wheels4 = { R.drawable.iswh4,R.drawable.iswh4side};

    private int[] currentCarImages;
    private int[] currentInteriorImages;
    private int[] currentengineImages;
    private int[] currentWheelsImages;

    private ImageView imageView;
    private ImageView secondImageView;
    private ImageView thirdImageView;
    private ImageView fourthImageView;


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
        fourthImageView = findViewById(R.id.fourthImage);


        ImageButton secondButton = findViewById(R.id.secondButton);
        ImageButton myButton = findViewById(R.id.myButton);
        ImageButton thirdButton = findViewById(R.id.thirdButton);
        ImageButton fourthButton = findViewById(R.id.fourthButton);
        ImageButton fifthButton = findViewById(R.id.fifthButton);
        Button sixthButton = findViewById(R.id.sixthButton);
        ImageButton seventhButton = findViewById(R.id.seventhButton);
        ImageButton eighthButton = findViewById(R.id.eighthButton);
        ImageButton ninthButton = findViewById(R.id.ninthButton);
        ImageButton tenthButton = findViewById(R.id.tenthButton);
        ImageButton eleventhButton = findViewById(R.id.eleventhButton);
        ImageButton fourteenthButton = findViewById(R.id.fourteenthButton);
        ImageButton fifteenthButton = findViewById(R.id.fifteenthButton);
        ImageButton sixteenthButton = findViewById(R.id.sixteenthButton);
        ImageButton wh1Button = findViewById(R.id.wh1Button);
        ImageButton wh2Button = findViewById(R.id.wh2Button);
        ImageButton wh3Button = findViewById(R.id.wh3Button);
        ImageButton wh4Button = findViewById(R.id.wh4Button);
        ImageButton whlButton = findViewById(R.id.whlButton);
        ImageButton whrButton = findViewById(R.id.whrButton);

        // Your other initialization code...

        // Set click listener for next image (first set)
        wh1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentWheelsImages = wheels1;
                currentFourthImageIndex = 0;  // Reset index when switching wheels
                updateFourthImageView();
                updateCarWheels("IS F SPORT");
            }
        });

        wh2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentWheelsImages = wheels2;
                currentFourthImageIndex = 0;  // Reset index when switching wheels
                updateFourthImageView();
                updateCarWheels("IS F SPORT");
            }
        });

        wh3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentWheelsImages = wheels3;
                currentFourthImageIndex = 0;  // Reset index when switching wheels
                updateFourthImageView();
                updateCarWheels("IS F SPORT");
            }
        });

        wh4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentWheelsImages = wheels4;
                currentFourthImageIndex = 0;  // Reset index when switching wheels
                updateFourthImageView();
                updateCarWheels("IS F SPORT");
            }
        });

        whlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousFourthImage();
            }
        });

        whrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextFourthImage();
            }
        });

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
        // Set click listener for sixth button (Next activity) - pass selected images to dealer activity
        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize selected images arrays
                int[] selectedCarImages;
                int[] selectedInteriorImages;
                int[] selectedEngineImages;
                int[] selectedWheelsImages;

                // Initialize descriptions
                String carDescription;
                String carInterior;
                String carEngine;
                String carWheels;

                // Check which images are currently selected
                if (currentCarImages == redCarImages) {
                    // If red car images are selected
                    selectedCarImages = redCarImages;
                    selectedInteriorImages = interiorbrown;
                    selectedEngineImages = engine;
                    selectedWheelsImages = currentWheelsImages; // Use the current wheels images

                    // Set descriptions for red car
                    carDescription = "Red Car Description";
                    carInterior = "Red Car Interior Description";
                    carEngine = "Red Car Engine Description";
                    carWheels = "Red Car Wheels Description";
                } else if (currentCarImages == whiteCarImages) {
                    // If white car images are selected
                    selectedCarImages = whiteCarImages;
                    selectedInteriorImages = interiorblack;
                    selectedEngineImages = engine1;
                    selectedWheelsImages = currentWheelsImages; // Use the current wheels images

                    // Set descriptions for white car
                    carDescription = "White Car Description";
                    carInterior = "White Car Interior Description";
                    carEngine = "White Car Engine Description";
                    carWheels = "White Car Wheels Description";
                } else {
                    // If default images are selected
                    selectedCarImages = imageResources;
                    selectedInteriorImages = interiored;
                    selectedEngineImages = engine2;
                    selectedWheelsImages = currentWheelsImages; // Use the current wheels images

                    // Set default descriptions
                    carDescription = "Default Car Description";
                    carInterior = "Default Car Interior Description";
                    carEngine = "Default Car Engine Description";
                    carWheels = "Default Car Wheels Description";
                }

                // Check if there are selected images
                if (selectedCarImages != null && selectedInteriorImages != null) {
                    // Pass the selected images and descriptions to the next activity
                    Intent intent = new Intent(lexusIS.this, dealerIS.class);
                    intent.putExtra("selectedCarImages", selectedCarImages);
                    intent.putExtra("selectedInteriorImages", selectedInteriorImages);
                    intent.putExtra("selectedEngineImages", selectedEngineImages);
                    intent.putExtra("selectedWheelsImages", selectedWheelsImages);

                    // Pass the descriptions
                    intent.putExtra("carDescription", carDescription);
                    intent.putExtra("carInterior", carInterior);
                    intent.putExtra("carEngine", carEngine);
                    intent.putExtra("carWheels", carWheels);

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
                updateCarinterior("IS F SPORT");
            }
        });

// Set click listener for tenth button (White car image) - update second image view
        tenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInteriorImages = interiorbrown;
                currentSecondImageIndex = 0;  // Reset index when switching cars
                updateSecondImageView();
                updateCarinterior("IS F SPORT");
            }
        });

// Set click listener for eleventh button (Black car image) - update second image view
        eleventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInteriorImages = interiored;
                currentSecondImageIndex = 0;  // Reset index when switching cars
                updateSecondImageView();
                updateCarinterior("IS F SPORT");
            }
        });

// Set click listener for fourteenth button (Red car image) - update third image view
        // Set click listener for fourteenth button (Red car image) - update third image view
        fourteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentengineImages = engine;  // Set to null to use the default images
                currentThirdImageIndex = 0;  // Reset index
                updateThirdImageView();
                updateCarengine("IS F SPORT");
            }
        });

// Set click listener for fifteenth button (White car image) - update third image view
        fifteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentengineImages = engine1;  // Set engine images for the first engine
                currentThirdImageIndex = 0;  // Reset index
                updateThirdImageView();
                updateCarengine("IS F SPORT");
            }
        });

// Set click listener for sixteenth button (Black car image) - update third image view
        sixteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentengineImages = engine2;  // Set engine images for the second engine
                currentThirdImageIndex = 0;  // Reset index
                updateThirdImageView();
                updateCarengine("IS F SPORT");
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



        // Your other click listeners...

        // Initial image display
        updateImageView();
        updateSecondImageView();
        updateThirdImageView();
        updateFourthImageView();
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
    private void showNextFourthImage() {
        currentFourthImageIndex = (currentFourthImageIndex + 1) % wheels1.length;
        updateFourthImageView();
    }
    private void showPreviousFourthImage() {
        currentFourthImageIndex = (currentFourthImageIndex - 1 + wheels1.length) % wheels1.length;
        updateFourthImageView();
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
    private void updateCarinterior(String description) {
        TextView carinteriorTextView = findViewById(R.id.carinterior);
        if (carinteriorTextView != null) {
            carinteriorTextView.setVisibility(View.VISIBLE);
            carinteriorTextView.setText(description);
        }
    }

    private void updateCarengine(String description) {
        TextView carengineTextView = findViewById(R.id.carengine);
        if (carengineTextView != null) {
            carengineTextView.setVisibility(View.VISIBLE);
            carengineTextView.setText(description);
        }
    }
    private void updateCarWheels(String description) {
        TextView carWheelsTextView = findViewById(R.id.carWheels);
        if (carWheelsTextView != null) {
            carWheelsTextView.setVisibility(View.VISIBLE);
            carWheelsTextView.setText(description);
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
        if (currentengineImages != null && currentThirdImageIndex >= 0 && currentThirdImageIndex < currentengineImages.length) {
            thirdImageView.setImageResource(currentengineImages[currentThirdImageIndex]);
        } else if (currentengineImages == null && currentThirdImageIndex >= 0 && currentThirdImageIndex < engine.length) {
            thirdImageView.setImageResource(engine[currentThirdImageIndex]);
        }
    }
    private void updateFourthImageView() {
        if (currentWheelsImages!= null && currentFourthImageIndex>= 0 && currentFourthImageIndex < currentWheelsImages.length) {
            fourthImageView.setImageResource(currentWheelsImages[currentFourthImageIndex]);
        } else if (currentFourthImageIndex >= 0 && currentFourthImageIndex < wheels1.length) {
            fourthImageView.setImageResource(wheels1[currentFourthImageIndex]);
        }
    }



    // Your other methods...

}

