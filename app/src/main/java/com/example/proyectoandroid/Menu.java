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
  private String url,url2,url3,url4;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        img1=findViewById(R.id.metro);
        spinner = findViewById(R.id.spinner);
        url = "https://www.youtube.com/user/el7desol";
        url2 = "https://twitter.com/ComunidadMadrid?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor";
        url3 = "https://es-es.facebook.com/ComunidadMadrid";
        Uri uri = Uri.parse(url);
        Uri uri2 = Uri.parse(url2);
        Uri uri3 = Uri.parse(url3);
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
                else
                    {
                        if (selectedItem.equals("Facebook"))
                        {

                            Intent i = new Intent(Intent.ACTION_VIEW,uri3);
                            startActivity(i);
                        }
                        else
                            {
                                if (selectedItem.equals("Twitter"))
                                {

                                    Intent i = new Intent(Intent.ACTION_VIEW,uri2);
                                    startActivity(i);
                                }

                        }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });






    }
}