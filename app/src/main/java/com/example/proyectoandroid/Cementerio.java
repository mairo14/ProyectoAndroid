package com.example.proyectoandroid;

public class Cementerio {


    public String title;
    public double latitude;
    public double longitude;
    public int cercania;

    public Cementerio(String title, double latitude, double longitude, int cercania) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cercania = cercania;
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

    public int getCercania() {
        return cercania;
    }

    public void setCercania(int cercania) {
        this.cercania = cercania;
    }
}
