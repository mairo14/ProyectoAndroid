package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearCuenta extends AppCompatActivity {

    Button crearSesion;
    EditText nombreRegistro, apellidoRegistro, usuarioRegistro, correoRegistro, contraseñaRegistro;
    String nombre;
    String apellido;
    String usuario;
    String correo;
    String contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        crearSesion = findViewById(R.id.Confirmar);
        nombreRegistro = findViewById(R.id.NombreRegistro);
        apellidoRegistro = findViewById(R.id.ApellidoRegistro);
        usuarioRegistro = findViewById(R.id.UsuarioRegistro);
        correoRegistro = findViewById(R.id.CorreoRegistro);
        contraseñaRegistro = findViewById(R.id.ContraseñaRegistro);


        crearSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = nombreRegistro.getText().toString();
                apellido = apellidoRegistro.getText().toString();
                usuario = usuarioRegistro.getText().toString();
                correo = correoRegistro.getText().toString();
                contraseña = contraseñaRegistro.getText().toString();
              if(!nombre.equals("") && !apellido.equals("") && !usuario.equals("") && !correo.equals("")&& !contraseña.equals("")){
                  CrearSesion( usuario, contraseña);

              }else{
                  Toast.makeText(getApplicationContext(),"Faltan datos",Toast.LENGTH_LONG).show();

              }

            }
        });


    }
    private void CrearSesion(String Usuario,String contraseña){


        Intent i = new Intent(CrearCuenta.this,MainActivity.class);
        i.putExtra("usuario", Usuario);
        i.putExtra("contraseña", contraseña);
        startActivity(i);



    }
}