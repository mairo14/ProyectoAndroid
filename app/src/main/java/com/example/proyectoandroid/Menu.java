package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import pl.droidsonroids.gif.GifImageView;

public class Menu extends AppCompatActivity {
  ImageView img1,img2,img3,img4;
  Spinner spinner;
  private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        img1=findViewById(R.id.metro);
        spinner = findViewById(R.id.spinner);
        url = "https://www.youtube.com/user/el7desol";
        Uri uri = Uri.parse(url);
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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.opciones, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Youtube"))
                {

                    Intent i = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


    }
}