package com.example.labtask8_4_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

public class UploadImage extends AppCompatActivity {

    private Button objUploadImgbtn;
    private EditText objUploadImageET;
    private ImageView objImageUploadIV;

    private FirebaseFirestore objFirebaseFirestore;
    private StorageReference objStorangeReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);

        objUploadImgbtn=findViewById(R.id.UploadImgBtn);
        objUploadImageET=findViewById(R.id.UploadImageET);
        objImageUploadIV=findViewById(R.id.UploadIV);

    }
}
