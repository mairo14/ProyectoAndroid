package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifImageView;

public class Menu extends AppCompatActivity {
  ImageView img1,img2,img3,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        img1=findViewById(R.id.metro);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img1.isClickable())
                {
                    Intent i = new Intent(Menu.this,Metro.class);
                    startActivity(i);
                }
            }
        });

    }

}