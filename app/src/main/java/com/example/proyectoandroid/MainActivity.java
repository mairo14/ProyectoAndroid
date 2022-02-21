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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Usuario> usu= new java.util.ArrayList<>();


    Button Reg, iniciar;
    String usuarioEscrito;
    String contraseñaEscrito;

    EditText usuario;
    EditText contraseña;
    int contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reg = findViewById(R.id.Registro);
        iniciar = findViewById(R.id.IniciarSesion);
        usuario = findViewById(R.id.UsuarioLogIn);
        contraseña = findViewById(R.id.ContraseñaLogIn);

        usu = CrearCuenta.usuarios;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
        if (contador ==1){
            contador++;
            usu.add(new Usuario("vacio","vacio","vacio","vacio","vacio"));
        }



        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,CrearCuenta.class);
              startActivity(i);


            }
        });
//------------------------------------------------------------------------------------------------------------------
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarioEscrito=usuario.getText().toString();
                contraseñaEscrito =contraseña.getText().toString();
                usu = CrearCuenta.usuarios;
                String usuarioVacio = "";
                String contraseñaVacia = "";
                if(usuarioEscrito.isEmpty() || contraseñaEscrito.isEmpty()){
                    Toast.makeText(MainActivity.this, "Contraseña o ususario invalidos", Toast.LENGTH_SHORT).show();
                } if(usuarioEscrito.equals(usuarioVacio) || contraseñaEscrito.equals(contraseñaVacia)){
                    Toast.makeText(MainActivity.this, "Contraseña o ususario invalidos", Toast.LENGTH_SHORT).show();
                }if(!usuarioEscrito.equals(usu.get(0).getUsuario()) || !contraseñaEscrito.equals(usu.get(0).getContraseña())){
                    Toast.makeText(MainActivity.this, "Contraseña o ususario invalidos", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Intent i = new Intent(MainActivity.this ,MarcarUbicacion.class);
                    startActivity(i);
                }




            }
        });
//-------------------------------------------------------------------------------------------------------------------------
    }
    public void setDayNight(int mode){
        if (mode == 0){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}