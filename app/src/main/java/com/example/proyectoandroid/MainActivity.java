package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Reg, iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reg = findViewById(R.id.Registro);
        iniciar = findViewById(R.id.IniciarSesion);

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                


            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}