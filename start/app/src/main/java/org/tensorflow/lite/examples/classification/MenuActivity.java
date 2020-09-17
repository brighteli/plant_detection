package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    private CardView profileBtn;
    private CardView captureBtn;
    private  CardView libraryBtn;
    private  CardView humanBtn;
    private  CardView historyBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        profileBtn = findViewById(R.id.btnProfile);
        captureBtn = findViewById(R.id.btnCapture);
        libraryBtn = findViewById(R.id.btnLibrary);
       // historyBtn= findViewById(R.id.btnHistory);


        libraryBtn.setOnClickListener(v -> {
            Intent libraryIntent = new Intent(MenuActivity.this , LibraryListActivity.class);
            startActivity(libraryIntent);

        });


        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent captureIntent = new Intent(MenuActivity.this , ClassifierActivity.class);
                startActivity(captureIntent);
            }
        });


       /* historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(MenuActivity.this,HistoryActivity.class);
                startActivity(historyIntent);
            }
        });*/


        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(MenuActivity.this,ProfileActivity.class);
                startActivity(profileIntent);
            }
        });





    }


}