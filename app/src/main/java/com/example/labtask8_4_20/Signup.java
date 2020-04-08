package com.example.labtask8_4_20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;

public class Signup extends AppCompatActivity {


    private ProgressBar objProgressBar;

    private EditText userEmail,userPassword;
    private Button objSignupbtn;

    private FirebaseAuth objFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        try {
            userEmail = findViewById(R.id.EmailET);
            userPassword = findViewById(R.id.PasswordET);

            objProgressBar = findViewById(R.id.ProgressBar);

            objFirebaseAuth = FirebaseAuth.getInstance();

            objSignupbtn = findViewById(R.id.SignUpBtn);

            objSignupbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CreateUser();
                }
            });
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void CreateUser()
    {
        try
        {
            if (!userEmail.getText().toString().isEmpty() && !userPassword.getText().toString().isEmpty())
            {
                objProgressBar.setVisibility(View.VISIBLE);
                objSignupbtn.setEnabled(false);

                objFirebaseAuth.createUserWithEmailAndPassword(userEmail.getText().toString(),
                        userPassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(Signup.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();

                        objProgressBar.setVisibility(View.INVISIBLE);
                        objSignupbtn.setEnabled(true);

                        userEmail.setText("");
                        userPassword.setText("");

                        if (objFirebaseAuth.getCurrentUser()!= null)
                        {
                            objFirebaseAuth.signOut();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        objProgressBar.setVisibility(View.INVISIBLE);
                        objSignupbtn.setEnabled(true);

                        Toast.makeText(Signup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else {
                Toast.makeText(this, "Please Filled the Fields", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
