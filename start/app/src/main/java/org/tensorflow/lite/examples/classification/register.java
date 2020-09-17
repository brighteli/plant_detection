package org.tensorflow.lite.examples.classification;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    Button reg, signup;
    EditText name, username, email, password;
    ProgressDialog progressD;
    FirebaseAuth mAuth;
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();


        reg = findViewById(R.id.btnRegister);
        signup = findViewById(R.id.btnsign);

        name = findViewById(R.id.edtName);
        username = findViewById(R.id.edtUserName);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);

        progressD = new ProgressDialog(this);


        reg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        registerUser();

                    }
                });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    void toastClass() {
        Toast.makeText(this, "Hi there",
                Toast.LENGTH_LONG).show();

    }


    private void registerUser() {

        String getName = name.getText().toString().trim();
        String getUsername = username.getText().toString().trim();
        String getEmail = email.getText().toString().trim();
        String getPassword = password.getText().toString().trim();


        if (TextUtils.isEmpty(getName)) {
            name.requestFocus();
            name.setError("name is required");

        }

        if (TextUtils.isEmpty(getUsername)) {
            username.requestFocus();
            username.setError("Username is required");
        }

        if (TextUtils.isEmpty(getEmail)) {
            email.requestFocus();
            email.setError("Email is required");
        }

        if (TextUtils.isEmpty(getPassword)) {
            password.requestFocus();
            password.setError("Password is required");
        } else {
            progressD.setTitle("loading");
            progressD.setMessage("wait while we register you");
            progressD.show();
            progressD.setCanceledOnTouchOutside(false);
            writeData(getEmail, getName, getPassword, getUsername);
        }

    }


    private void writeData(final String getEmail, final String getName,
                           final String getPassword,
                           final String getUsername) {
        mAuth.createUserWithEmailAndPassword(getEmail, getPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("checkSuccess", "Success");
                        String uid = mAuth.getCurrentUser().getUid();

                        if (task.isSuccessful()) {
                            Map<String, String> registerData = new HashMap<>();
                            registerData.put("Full Name", getName);
                            registerData.put("User Name ", getUsername);
                            registerData.put("Email", getEmail);
                            registerData.put("Password ", getPassword);

                            db.collection("users")
                                    .document(uid)
                                    .set(registerData)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                              @Override
                            public void onSuccess(Void aVoid) {
                                // set the user to the login page
                           progressD.dismiss();
                               Intent eli = new Intent(register.this, LoginActivity.class);
                            startActivity(eli);

                   }
               }
               );
                        }
                    }
                });


    }
}
