package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class LibraryActivity extends AppCompatActivity {

    private ImageView treeImage;
    private TextView  treeName;
    private TextView  scientificName;
    private TextView  treeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        treeImage = findViewById(R.id.plantImageView);
        treeName = findViewById(R.id.txtPlantName);
        scientificName = findViewById(R.id.txtScienfiicName);
        treeDescription = findViewById(R.id.txtPlantDescriptiion);


        //binding all data into these views(post data)

        String treeImagee = getIntent().getExtras().getString("treeimage");
        Glide.with(this).load(treeImagee).into(treeImage);

        String treeNamee = getIntent().getExtras().getString("treename");
        treeName.setText(treeNamee);

        String scientificNamee = getIntent().getExtras().getString("scientificname");
        scientificName.setText(scientificNamee);

        String treeDescriptionn = getIntent().getExtras().getString("treedescription");
        treeDescription.setText(treeDescriptionn);


    }
}