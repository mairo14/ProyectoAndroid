package com.example.proyectoandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoAPI {
    @GET("catalogo/205026-0-cementerios.json'")
    Call<List<Restaurante>> getPosts();
}
