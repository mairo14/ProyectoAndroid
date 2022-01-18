package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoRes extends AppCompatActivity {

    ArrayList<Restaurante> listado= new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_res);
        listView = findViewById(R.id.Restaurantes);

        listado.add(new Restaurante("CAsa PIli", R.drawable.bulbasaur));
        listado.add(new Restaurante("CAsa FErnando", R.drawable.ivysaur));
        AdaptadorPersonalizado adaptador = new AdaptadorPersonalizado(listado, this);
        listView.setAdapter(adaptador);
    }
}