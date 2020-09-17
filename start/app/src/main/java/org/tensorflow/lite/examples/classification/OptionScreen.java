package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionScreen extends AppCompatActivity {

    Button selectbtn;
    Button snapbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_screen);

            snapbtn=findViewById(R.id.btnSnap);
            selectbtn=findViewById(R.id.btnSelect);



             snapbtn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

           Intent option = new Intent(OptionScreen.this,ClassifierActivity.class);
                 startActivity(option);
                 }
             });



    }
}