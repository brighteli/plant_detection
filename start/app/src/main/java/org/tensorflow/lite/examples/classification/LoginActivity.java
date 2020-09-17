package org.tensorflow.lite.examples.classification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    Button signin;
    Button register;
    EditText mail,password;
    ProgressDialog progressD;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signin=findViewById(R.id.btnsign);
        register=findViewById(R.id.btnRegister);

        mail=findViewById(R.id.edtEmail);
        password=findViewById(R.id.edtPassword);

        progressD = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();


        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent eli = new Intent(LoginActivity.this,register.class);
                        startActivity(eli);
                    }
                });


        signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        LoginUser();
                    }
                });


    }
    void toastClass()
    {
        Toast.makeText(this,"Please check your email or password",
                Toast.LENGTH_LONG).show();

    }


    private void LoginUser()
    {
        String getMail  = mail.getText().toString().trim();
        String getPass = password.getText().toString().trim();

        if(TextUtils.isEmpty(getMail))
        {
            mail.requestFocus();
            mail.setError("Username is required");
        }


        if(TextUtils.isEmpty(getPass))
        {
            password.requestFocus();
            password.setError("Password is required");
        }

        else
        {
            progressD.setTitle("loading");
            progressD.setMessage("wait while we authenticate you");
            progressD.show();
            progressD.setCanceledOnTouchOutside(false);

            mAuth.signInWithEmailAndPassword(getMail,getPass)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>()
                    {
                        @Override
                        public void onSuccess(AuthResult authResult)
                        {
                            progressD.dismiss();
                            // set the user to a new page
         Intent eli = new Intent(LoginActivity.this,MenuActivity.class);
                            startActivity(eli);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    toastClass();
                    progressD.dismiss();

                }
            });
        }

    }
}

