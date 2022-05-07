package com.mine.facedetector;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FullImageView extends AppCompatActivity {

    Context context = this;

    ImageView imgFullImage;
    OutputStream outputStream;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);
        imgFullImage = findViewById(R.id.imgFullImage);
        //ActivityCompat.requestPermissions(FullImageView.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        //ActivityCompat.requestPermissions(FullImageView.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);

        Bitmap bitmap = null;

        try {
            bitmap = BitmapFactory.decodeStream(context.openFileInput("myImage"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imgFullImage.setImageBitmap(bitmap);

    }
}
