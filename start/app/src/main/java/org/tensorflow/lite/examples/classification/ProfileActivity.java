package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText txtPassword;
    private EditText txtEmail;
    private EditText txtPhone;
    private Button  btnSave;



    String _PASSWORD,_EMAIL ,_PHONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.image_view);
        txtEmail = findViewById(R.id.text_email);
        txtPassword = findViewById(R.id.text_password);
        txtPhone = findViewById(R.id.text_phone);
        btnSave = findViewById(R.id.button_save);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        showAllUserData();

    }

    private void isPasswordChanged() {

    }

    private void isEmailChanged()
    {
    }


    private void showAllUserData(){

        Intent intent = getIntent();
        _EMAIL = intent.getStringExtra("email");
        _PASSWORD = intent.getStringExtra("password");
        _PHONE = intent.getStringExtra("phone");



    }


}