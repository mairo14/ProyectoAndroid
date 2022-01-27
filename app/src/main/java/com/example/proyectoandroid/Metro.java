package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class Metro extends AppCompatActivity
{
    static  ArrayList<String> urlIma = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    TextView nombre;
    ListView listView;
    ArrayList<Metro> centros = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metro);
        nombre = findViewById(R.id.textNombre);
        listView = findViewById(R.id.listView);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    Document resCompleto = Jsoup.connect("https://datos.madrid.es/egob/catalogo/200337-0-centros-mayores.json").get();
                    arrayList = (ArrayList<String>) resCompleto.select("GET /catalogo/200337-0-centros-mayores.json").eachText();
                    arrayList.remove(0);
                    for (int i = 0; i < arrayList.size(); i++)
                    {
                    String numCentros = String.format("%03d",i + 1);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}