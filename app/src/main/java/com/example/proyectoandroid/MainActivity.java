package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Button Reg, iniciar;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String llave = "sesion";
    CheckBox recordar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reg = findViewById(R.id.Registro);
        iniciar = findViewById(R.id.IniciarSesion);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
        if (revisarSesion()){
            startActivity(new Intent(this, RecuperarContrasenia.class));
        }


        if (revisarSesion()){
            startActivity(new Intent(this, RecuperarContrasenia.class));
        }
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CrearCuenta.class);
                startActivity(i);


            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ListadoRes.class);
                guardarSesion(recordar.isChecked());
                startActivity(i);
            }
        });

    }
    public void setDayNight(int mode){
        if (mode == 0){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private boolean revisarSesion(){
        boolean sesion = this.preferences.getBoolean(llave, false);
        return false;
    }

    private void guardarSesion(boolean checked){
        editor.putBoolean(llave,checked);
        editor.apply();
    }

    private void inicializarElemento(){
        preferences = this.getPreferences(Context.MODE_PRIVATE);
        editor = preferences.edit();
        recordar = findViewById(R.id.recordarcontraseña);
    }
}