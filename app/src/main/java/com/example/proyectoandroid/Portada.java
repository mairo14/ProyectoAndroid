package com.example.proyectoandroid;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Portada extends AppCompatActivity {
    Handler handler = new Handler();
    ImageView img , img2,img3,img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);
        img= findViewById(R.id.gif);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Portada.this,MainActivity.class);
                startActivity(i);
            }
        },10000);

img2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (img2.isClickable())
        {
            Toast.makeText(Portada.this, "Teléfono : 012", Toast.LENGTH_SHORT).show();
        }
    }
});
img3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (img3.isClickable())
        {
            Toast.makeText(Portada.this, "Teléfono : 900 102 112", Toast.LENGTH_SHORT).show();
        }
    }
});

img4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (img4.isClickable())
        {
            Toast.makeText(Portada.this, "Teléfono : 112", Toast.LENGTH_SHORT).show();
        }
    }
});


    }







}