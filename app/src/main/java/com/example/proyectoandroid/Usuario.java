package com.example.proyectoandroid;

public class Usuario {

    String nombre;
    String apellido;
    String usuario;
    String correo;
    String contraseña;

    public Usuario(String nombre, String apellido, String usuario, String correo, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
