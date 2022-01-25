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
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        img= findViewById(R.id.gif);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Portada.this,MainActivity.class);
                startActivity(i);
            }
        },10000);




    }







}