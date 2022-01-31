package com.example.proyectoandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoAPI {
    @GET("catalogo/205026-0-cementerios.json?latitud=40.472032763100025&longitud=-3.6406523385659426&distancia=5000'")
    Call<RestauranteLLamada> getPosts();
}
