package com.example.proyectoandroid;

public class Seleccionados {
    public String title;
    public double latitude;
    public double longitude;
    public String tipo;

    public Seleccionados(String title, double latitude, double longitude, String tipo) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tipo = tipo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
