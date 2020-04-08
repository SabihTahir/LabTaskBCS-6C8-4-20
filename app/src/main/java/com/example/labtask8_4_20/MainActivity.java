package com.example.labtask8_4_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void MoveToSignUpAct(View v)
    {
        startActivity(new Intent(this,Signup.class));
    }
    public void MoveToSignInAct(View v)
    {
        startActivity(new Intent(this,Signin.class));
    }
    public void MoveToUploadImage(View v)
    {
        startActivity(new Intent(this,UploadImage.class));
    }
    public void MoveToUploadVideo(View v)
    {
        startActivity(new Intent(this,UploadVideo.class));
    }
    public void MoveToDownloadImage(View v)
    {
        startActivity(new Intent(this,DownoadImage.class));
    }
    public void MoveToDownloadVideo(View v)
    {
        startActivity(new Intent(this,DownloadVideo.class));
    }
}
