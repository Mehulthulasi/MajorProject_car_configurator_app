package com.example.majorproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;

public class lexusIS extends AppCompatActivity {

    private ImageView imageView1; // For the first folder
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;// For the next folder
    private ImageButton prevButton;
    private ImageButton nextButton;
    private ImageButton thirdButton;
    private ImageButton fourthButton;
    private ImageButton fifthButton;
    private ImageButton seventhButton;
    private ImageButton eighthButton;
    private ImageButton ninthButton;
    private ImageButton tenthButton;
    private ImageButton eleventhButton;
    private ImageButton fourteenthButton;
    private ImageButton fifteenthButton;
    private ImageButton sixteenthButton;
    private  ImageButton whrButton;
    private  ImageButton whlButton;
    private  ImageButton wh1Button;
    private  ImageButton wh2Button;
    private  ImageButton wh3Button;
    private  ImageButton wh4Button;
    private Button sixthButton;
    private TextView color1;
    private TextView color2;
    private TextView color3;
    private TextView interiorcolor1;
    private TextView interiorcolor2;
    private TextView interiorcolor3;
    private TextView engine1;
    private TextView engine2;
    private TextView engine3;
    private TextView wheelDescriptionTextView1;
    private TextView wheelDescriptionTextView2;
    private TextView wheelDescriptionTextView3;
    private TextView wheelDescriptionTextView4;


    private FirebaseStorage storage;
    private StorageReference storageReference1; // For the first folder
    private StorageReference storageReference2; // For the next folder
    private StorageReference storageReference3;
    private StorageReference storageReference4;
    private ArrayList<String> imageNames1; // For the first folder
    private ArrayList<String> imageNames2; // For the next folder
    private ArrayList<String> imageNames3;
    private ArrayList<String> imageNames4;
    private int currentIndex1;
    private int currentIndex2;
    private int currentIndex3;
    private int currentIndex4;
    private boolean loadDefaultImages = true;
    private boolean loadDefaultImages2 = true;
    private boolean loadDefaultImages3 = true;
    private boolean loadDefaultImages4 = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lexus_is);

        imageView1 = findViewById(R.id.middleImage);
        imageView2 = findViewById(R.id.secondImage);
        imageView3 = findViewById(R.id.thirdImage);
        imageView4 = findViewById(R.id.fourthImage);
        prevButton = findViewById(R.id.myButton);
        nextButton = findViewById(R.id.secondButton);
        thirdButton = findViewById(R.id.thirdButton);
        fourthButton = findViewById(R.id.fourthButton);
        fifthButton = findViewById(R.id.fifthButton);
        seventhButton = findViewById(R.id.seventhButton);
        eighthButton = findViewById(R.id.eighthButton);
        ninthButton = findViewById(R.id.ninthButton);
        tenthButton = findViewById(R.id.tenthButton);
        eleventhButton = findViewById(R.id.eleventhButton);
        fourteenthButton = findViewById(R.id.fourteenthButton);
        fifteenthButton = findViewById(R.id.fifteenthButton);
        sixteenthButton = findViewById(R.id.sixteenthButton);
        whrButton=findViewById(R.id.whrButton);
        whlButton=findViewById(R.id.whlButton);
        wh1Button=findViewById(R.id.wh1Button);
        wh2Button=findViewById(R.id.wh2Button);
        wh3Button=findViewById(R.id.wh3Button);
        wh4Button=findViewById(R.id.wh4Button);
        sixthButton=findViewById(R.id.sixthButton);
        color1=findViewById(R.id.carDescription);
        color2=findViewById(R.id.carDescription);
        color3=findViewById(R.id.carDescription);
        interiorcolor1=findViewById(R.id.carinterior);
        interiorcolor2=findViewById(R.id.carinterior);
        interiorcolor3=findViewById(R.id.carinterior);
        engine1=findViewById(R.id.carengine);
        engine2=findViewById(R.id.carengine);
        engine3=findViewById(R.id.carengine);
        wheelDescriptionTextView1 = findViewById(R.id.carWheels);
        wheelDescriptionTextView2 = findViewById(R.id.carWheels);
        wheelDescriptionTextView3= findViewById(R.id.carWheels);
        wheelDescriptionTextView4 = findViewById(R.id.carWheels);
        color1.setVisibility(View.GONE);
        color2.setVisibility(View.GONE);
        color3.setVisibility(View.GONE);
        interiorcolor1.setVisibility(View.GONE);
        interiorcolor2.setVisibility(View.GONE);
        interiorcolor3.setVisibility(View.GONE);
        engine1.setVisibility(View.GONE);
        engine2.setVisibility(View.GONE);
        engine3.setVisibility(View.GONE);
        wheelDescriptionTextView1.setVisibility(View.GONE);
        wheelDescriptionTextView2.setVisibility(View.GONE);
        wheelDescriptionTextView3.setVisibility(View.GONE);
        wheelDescriptionTextView4.setVisibility(View.GONE);


        // Initialize Firebase Storage
        storage = FirebaseStorage.getInstance();

        // Initialize StorageReferences for both folders
        storageReference1 = storage.getReference().child("is_white");
        storageReference2 = storage.getReference().child("interior");
        storageReference3 = storage.getReference().child("engine");
        storageReference4 = storage.getReference().child("wheels");

        // Initialize image names lists
        imageNames1 = new ArrayList<>();
        imageNames1.add("is1.jpeg");
        imageNames1.add("isr4.jpeg");
        imageNames1.add("isr3.jpeg");

        imageNames2 = new ArrayList<>();
        imageNames2.add("isinblc1.jpeg");
        imageNames2.add("next_image2.jpeg");
        imageNames2.add("next_image3.jpeg");

        imageNames3 = new ArrayList<>();
        imageNames3.add("is300.jpeg");
        imageNames3.add("is350.jpeg");
        imageNames3.add("isf.jpeg");

        imageNames4 = new ArrayList<>();
        imageNames4.add("iswh1.jpeg");
        imageNames4.add("iswh2.jpeg");
        imageNames4.add("iswh3.jpeg");



        // Set current indices
        currentIndex1 = 0;
        currentIndex2 = 0;
        currentIndex3 = 0;
        currentIndex4 = 0;

        // Load first images
        loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
        loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
        loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
        loadImage(imageView4, storageReference4, imageNames4, currentIndex4);


        // Set click listeners for next and previous buttons
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousImage();
            }
        });
        seventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousImage2();
            }
        });
        whlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousImage3();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextImage();
            }
        });
        eighthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextImage2();
            }
        });
        whrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextImage3();
            }
        });
        /////////////////////////left right button:)

        // Set click listener for the thirdButton to load specific images
        ///exterior color
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages();
                showcolor1("Description for Wheel 1");
            }
        });

        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages1();
                showcolor2("Description for Wheel 1");
            }
        });

        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages2();
                showcolor3("Description for Wheel 1");
            }
        });
        ///exterior color end
        ///interior color start
        ninthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages3();
                showinteriorcolor1("Description for Wheel 1");

            }
        });

        tenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages4();
                showinteriorcolor2("Description for Wheel 1");

            }
        });

        eleventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages5();
                showinteriorcolor3("Description for Wheel 1");

            }
        });
        //////////interior color end//
        ////engine option start///
        fourteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages6();
                showengine1("Description for Wheel 1");

            }
        });
        fifteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages7();
                showengine2("Description for Wheel 1");
            }
        });
        sixteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages8();
                showengine3("Description for Wheel 1");
            }
        });
        //////engine option end/////
        //////wheel option start//////
        wh1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages9();
                // Show or update the description
                showWheelDescription1("Description for Wheel 1");
            }
        });

        wh2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages10();
                showWheelDescription2("Description for Wheel 1");
            }
        });
        wh3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages11();
                showWheelDescription3("Description for Wheel 1");
            }
        });
        wh4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpecificImages12();
                showWheelDescription4("Description for Wheel 1");
            }
        });
        ////wheel option end//////
        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize selected images arrays
                ArrayList<String> selectedCarImages;
                ArrayList<String> selectedInteriorImages;
                ArrayList<String> selectedEngineImages;
                ArrayList<String> selectedWheelsImages;

                // Initialize descriptions
                String carDescription;
                String carInterior;
                String carEngine;
                String carWheels;

                // Check which images are currently selected
                if (!loadDefaultImages) {
                    // If images from the first folder are selected
                    selectedCarImages = imageNames1;
                    selectedInteriorImages = imageNames2;
                    selectedEngineImages = imageNames3;
                    selectedWheelsImages = imageNames4;

                    // Set descriptions for the first set of images
                    carDescription = "Description for first set of images";
                    carInterior = "Interior description for first set of images";
                    carEngine = "Engine description for first set of images";
                    carWheels = "Wheels description for first set of images";
                } else {
                    // If default images are selected
                    selectedCarImages = new ArrayList<>();
                    selectedInteriorImages = new ArrayList<>();
                    selectedEngineImages = new ArrayList<>();
                    selectedWheelsImages = new ArrayList<>();

                    // Set default descriptions
                    carDescription = "Default Car Description";
                    carInterior = "Default Car Interior Description";
                    carEngine = "Default Car Engine Description";
                    carWheels = "Default Car Wheels Description";
                }

                // Check if there are selected images
                // Check if there are selected images
                if (!selectedCarImages.isEmpty() && !selectedInteriorImages.isEmpty() && !selectedEngineImages.isEmpty() && !selectedWheelsImages.isEmpty()) {
                    // Pass the selected images and descriptions to the next activity
                    Intent intent = new Intent(lexusIS.this, dealerIS.class);
                    intent.putStringArrayListExtra("selectedCarImages", selectedCarImages);
                    intent.putStringArrayListExtra("selectedInteriorImages", selectedInteriorImages);
                    intent.putStringArrayListExtra("selectedEngineImages", selectedEngineImages);
                    intent.putStringArrayListExtra("selectedWheelsImages", selectedWheelsImages);

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



    }

    private void showNextImage() {
        currentIndex1 = (currentIndex1 + 1) % imageNames1.size();
        loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
    }

    private void showPreviousImage() {
        currentIndex1 = (currentIndex1 - 1 + imageNames1.size()) % imageNames1.size();
        loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
    }
    private void showNextImage2() {
        currentIndex2 = (currentIndex2 + 1) % imageNames2.size();
        loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
    }

    private void showPreviousImage2() {
        currentIndex2 = (currentIndex2 - 1 + imageNames2.size()) % imageNames2.size();
        loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
    }
    private void showNextImage3() {
        currentIndex3 = (currentIndex3 + 1) % imageNames3.size();
        loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
    }

    private void showPreviousImage3() {
        currentIndex3 = (currentIndex3 - 1 + imageNames3.size()) % imageNames3.size();
        loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
    }

    private void loadImage(ImageView imageView, StorageReference storageReference, ArrayList<String> imageNames, int currentIndex) {
        StorageReference imageRef = storageReference.child(imageNames.get(currentIndex));
        final long ONE_MEGABYTE = 1024 * 1024;

        imageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Convert bytes data to Bitmap
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                // Set Bitmap to ImageView
                imageView.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Handle any errors
                e.printStackTrace();
            }
        });
    }

    // Method to load specific images
    private void loadSpecificImages() {
        if (loadDefaultImages) {
            // Clear the existing image names list
            imageNames1.clear();
            // Add the specific image names
            imageNames1.add("is.jpeg");
            imageNames1.add("is2.jpeg");
            imageNames1.add("is3.jpeg");
            imageNames1.add("is4.jpeg");
            imageNames1.add("is5.jpeg");
            // Reset the current index
            currentIndex1 = 0;
            // Load the first image
            loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
            loadDefaultImages = false;
        } else {
            // Reset to default images
            imageNames1.clear();
            imageNames1.add("is2.jpeg");
            imageNames1.add("is4.jpeg");
            imageNames1.add("is3.jpeg");
            // Reset the current index
            currentIndex1 = 0;
            // Load the first image
            loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
            loadDefaultImages = true;
        }
    }
    private void loadSpecificImages1() {
        if (loadDefaultImages) {
            // Clear the existing image names list
            imageNames1.clear();
            // Add the specific image names
            imageNames1.add("isb1.jpeg");
            imageNames1.add("isb2.jpeg");
            imageNames1.add("isb3.jpeg");
            imageNames1.add("isb4.jpeg");
            imageNames1.add("isb5.jpeg");
            // Reset the current index
            currentIndex1 = 0;
            // Load the first image
            loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
            loadDefaultImages = false;
        } else {
            // Reset to default images
            imageNames1.clear();
            imageNames1.add("is2.jpeg");
            imageNames1.add("is4.jpeg");
            imageNames1.add("is3.jpeg");
            // Reset the current index
            currentIndex1 = 0;
            // Load the first image
            loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
            loadDefaultImages = true;
        }
    }
    private void loadSpecificImages2() {
        if (loadDefaultImages) {
            // Clear the existing image names list
            imageNames1.clear();
            // Add the specific image names
            imageNames1.add("isr1.jpeg");
            imageNames1.add("isr2.jpeg");
            imageNames1.add("isr3.jpeg");
            imageNames1.add("isr4.jpeg");
            imageNames1.add("isr5.jpeg");
            // Reset the current index
            currentIndex1 = 0;
            // Load the first image
            loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
            loadDefaultImages = false;
        } else {
            // Reset to default images
            imageNames1.clear();
            imageNames1.add("is2.jpeg");
            imageNames1.add("is4.jpeg");
            imageNames1.add("is3.jpeg");
            // Reset the current index
            currentIndex1 = 0;
            // Load the first image
            loadImage(imageView1, storageReference1, imageNames1, currentIndex1);
            loadDefaultImages = true;
        }
    }
    ////interior///////////////////////////////////////////////////////
    private void loadSpecificImages3() {
        if (loadDefaultImages2) {
            // Clear the existing image names list
            imageNames2.clear();
            // Add the specific image names
            imageNames2.add("isinblc1.jpeg");
            imageNames2.add("isinblc2.jpeg");
            // Reset the current index
            currentIndex2 = 0;
            // Load the first image
            loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
            loadDefaultImages2 = false;
        } else {
            // Reset to default images
            imageNames2.clear();
            imageNames2.add("isinblc1.jpeg");
            imageNames2.add("isinblc1.jpeg");
            imageNames2.add("isinblc1.jpeg");
            // Reset the current index
            currentIndex2 = 0;
            // Load the first image
            loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
            loadDefaultImages2 = true;
        }
    }

    private void loadSpecificImages4() {
        if (loadDefaultImages2) {
            // Clear the existing image names list
            imageNames2.clear();
            // Add the specific image names
            imageNames2.add("isinbro1.jpeg");
            imageNames2.add("isinbro2.jpeg");
            // Reset the current index
            currentIndex2 = 0;
            // Load the first image
            loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
            loadDefaultImages2 = false;
        } else {
            // Reset to default images
            imageNames2.clear();
            imageNames2.add("isinblc1.jpeg");
            imageNames2.add("isinblc1.jpeg");
            imageNames2.add("isinblc1.jpeg");
            // Reset the current index
            currentIndex2 = 0;
            // Load the first image
            loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
            loadDefaultImages2 = true;
        }
    }

    private void loadSpecificImages5() {
        if (loadDefaultImages2) {
            // Clear the existing image names list
            imageNames2.clear();
            // Add the specific image names
            imageNames2.add("isinred1.jpeg");
            imageNames2.add("isinred2.jpeg");
            // Reset the current index
            currentIndex2 = 0;
            // Load the first image
            loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
            loadDefaultImages2 = false;
        } else {
            // Reset to default images
            imageNames2.clear();
            imageNames2.add("isinblc1.jpeg");
            imageNames2.add("isinblc1.jpeg");
            imageNames2.add("isinblc1.jpeg");
            // Reset the current index
            currentIndex2 = 0;
            // Load the first image
            loadImage(imageView2, storageReference2, imageNames2, currentIndex2);
            loadDefaultImages2 = true;
        }
    }
    //////////////////
    private void loadSpecificImages6() {
        if (loadDefaultImages3) {
            // Clear the existing image names list
            imageNames3.clear();
            // Add the specific image names
            imageNames3.add("is300.jpeg");
            // Reset the current index
            currentIndex3 = 0;
            // Load the first image
            loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
            loadDefaultImages3 = false;
        } else {
            // Reset to default images
            imageNames3.clear();
            imageNames3.add("is300.jpeg");
            // Reset the current index
            currentIndex3 = 0;
            // Load the first image
            loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
            loadDefaultImages3 = true;
        }
    }
    private void loadSpecificImages7() {
        if (loadDefaultImages3) {
            // Clear the existing image names list
            imageNames3.clear();
            // Add the specific image names
            imageNames3.add("is350.jpeg");
            // Reset the current index
            currentIndex3 = 0;
            // Load the first image
            loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
            loadDefaultImages3 = false;
        } else {
            // Reset to default images
            imageNames3.clear();
            imageNames3.add("is300.jpeg");
            // Reset the current index
            currentIndex3 = 0;
            // Load the first image
            loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
            loadDefaultImages3 = true;
        }
    }
    private void loadSpecificImages8() {
        if (loadDefaultImages3) {
            // Clear the existing image names list
            imageNames3.clear();
            // Add the specific image names
            imageNames3.add("isf.jpeg");
            // Reset the current index
            currentIndex3 = 0;
            // Load the first image
            loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
            loadDefaultImages3 = false;
        } else {
            // Reset to default images
            imageNames3.clear();
            imageNames3.add("is300.jpeg");
            // Reset the current index
            currentIndex3 = 0;
            // Load the first image
            loadImage(imageView3, storageReference3, imageNames3, currentIndex3);
            loadDefaultImages3 = true;
        }
    }
    private void loadSpecificImages9() {
        if (loadDefaultImages3) {
            // Clear the existing image names list
            imageNames4.clear();
            // Add the specific image names
            imageNames4.add("iswh1.jpeg");
            imageNames4.add("iswh1side.jpeg");
            // Reset the current index
            currentIndex4 = 0;
            // Load the first image
            loadImage(imageView4, storageReference4, imageNames4, currentIndex4);
            loadDefaultImages4 = false;
        } else {
            // Reset to default images
            imageNames4.clear();
            imageNames4.add("iswh1.jpeg");
            // Reset the current index
            currentIndex4 = 0;
            // Load the first image
            loadImage(imageView4, storageReference4, imageNames4, currentIndex4);
            loadDefaultImages4 = true;
        }
    }
    private void loadSpecificImages10() {
        if (loadDefaultImages3) {
            // Clear the existing image names list
            imageNames4.clear();
            // Add the specific image names
            imageNames4.add("iswh2.jpeg");
            imageNames4.add("iswh2side.jpeg");
            // Reset the current index
            currentIndex4 = 0;
            // Load the first image
            loadImage(imageView4, storageReference4, imageNames4, currentIndex4);
            loadDefaultImages4 = false;
        } else {
            // Reset to default images
            imageNames4.clear();
            imageNames4.add("iswh1.jpeg");
            // Reset the current index
            currentIndex4 = 0;
            // Load the first image
            loadImage(imageView4, storageReference4, imageNames4, currentIndex4);
            loadDefaultImages4 = true;
        }
    }
    private void loadSpecificImages11() {
        if (loadDefaultImages3) {
            // Clear the existing image names list
            imageNames4.clear();
            // Add the specific image names
            imageNames4.add("iswh3.jpeg");
            imageNames4.add("iswh3side.jpeg");
            // Reset the current index
            currentIndex4 = 0;
            // Load the first image
            loadImage(imageView4, storageReference4, imageNames4, currentIndex4);
            loadDefaultImages4 = false;
        } else {
            // Reset to default images
            imageNames4.clear();
            imageNames4.add("iswh1.jpeg");            // Reset the current index
            currentIndex4 = 0;
            // Load the first image
            loadImage(imageView4, storageReference4, imageNames4, currentIndex4);
            loadDefaultImages4 = true;
        }
    }
    private void loadSpecificImages12() {
        if (loadDefaultImages3) {
            // Clear the existing image names list
            imageNames4.clear();
            // Add the specific image names
            imageNames4.add("iswh4.jpeg");
            imageNames4.add("iswh4side.jpeg");

            // Reset the current index
            currentIndex4 = 0;
            // Load the first image
            loadImage(imageView4, storageReference4, imageNames4, currentIndex4);
            loadDefaultImages4 = false;
        } else {
            // Reset to default images
            imageNames4.clear();
            imageNames4.add("iswh1.jpeg");            // Reset the current index

            // Reset the current index
            currentIndex4 = 0;
            // Load the first image
            loadImage(imageView4, storageReference4, imageNames4, currentIndex4);
            loadDefaultImages4 = true;
        }
    }
    private void showcolor1(String description) {
        color1.setText(description);
        color1.setVisibility(View.VISIBLE);
    }

    private void showcolor2(String description) {
        color2.setText(description);
        color2.setVisibility(View.VISIBLE);
    }

    private void showcolor3(String description) {
        color3.setText(description);
        color3.setVisibility(View.VISIBLE);
    }

    private void showinteriorcolor1(String description) {
        interiorcolor1.setText(description);
        interiorcolor1.setVisibility(View.VISIBLE);
    }
    private void showinteriorcolor2(String description) {
        interiorcolor2.setText(description);
        interiorcolor2.setVisibility(View.VISIBLE);
    }
    private void showinteriorcolor3(String description) {
        interiorcolor2.setText(description);
        interiorcolor2.setVisibility(View.VISIBLE);
    }
    private void showengine1(String description) {
        engine1.setText(description);
        engine1.setVisibility(View.VISIBLE);
    }
    private void showengine2(String description) {
        engine2.setText(description);
        engine2.setVisibility(View.VISIBLE);
    }
    private void showengine3(String description) {
        engine3.setText(description);
        engine3.setVisibility(View.VISIBLE);
    }
    private void showWheelDescription1(String description) {
        wheelDescriptionTextView1.setText(description);
        wheelDescriptionTextView1.setVisibility(View.VISIBLE);
    }
    private void showWheelDescription2(String description) {
        wheelDescriptionTextView2.setText(description);
        wheelDescriptionTextView2.setVisibility(View.VISIBLE);
    }
    private void showWheelDescription3(String description) {
        wheelDescriptionTextView3.setText(description);
        wheelDescriptionTextView3.setVisibility(View.VISIBLE);
    }
    private void showWheelDescription4(String description) {
        wheelDescriptionTextView4.setText(description);
        wheelDescriptionTextView4.setVisibility(View.VISIBLE);
    }


}
