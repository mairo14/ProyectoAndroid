package com.example.proyectoandroid;

import java.util.ArrayList;

public class RestauranteLLamada {

    private ArrayList<Restaurante> restaurante;
    private boolean error;

    public ArrayList<Restaurante> getRestaurante() {

        return restaurante;
    }

    public void setRestaurante(ArrayList<Restaurante> restaurante) {
        this.restaurante = restaurante;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
