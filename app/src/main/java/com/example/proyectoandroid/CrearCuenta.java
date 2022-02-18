package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearCuenta extends AppCompatActivity {

    static ArrayList<Usuario> usuarios= new java.util.ArrayList<>();

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
                  usuarios.add(new Usuario(nombre, apellido, usuario,correo,contraseña));
                  Toast.makeText(getApplicationContext(),"Usuario creado",Toast.LENGTH_LONG).show();
                  Intent i = new Intent(CrearCuenta.this,MainActivity.class);
                  startActivity(i);

              }else{


              }
            }
        });
    }
}