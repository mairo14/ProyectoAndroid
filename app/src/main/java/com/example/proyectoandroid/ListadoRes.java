package com.example.proyectoandroid;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListadoRes extends AppCompatActivity {

    ArrayList<Restaurante> listado= new ArrayList<>();
    ListView listView;
    AdaptadorPersonalizado adaptador;
    TextView tvejemplo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_res);
        tvejemplo = findViewById(R.id.Ejemplo);

        find();

    }
    private void poblarSpinnerRestaurantes(ArrayList<Restaurante> restaurantes){

    }

    private void find(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://datos.madrid.es/egob/").addConverterFactory(GsonConverterFactory.create()).build();
        ProductoAPI productoAPI = retrofit.create(ProductoAPI.class);
        Call<RestauranteLLamada> call = productoAPI.getPosts();
        call.enqueue(new RestauranteCallback());
    }
    class RestauranteCallback implements Callback<RestauranteLLamada> {

        @Override
        public void onResponse(Call<RestauranteLLamada> call, Response<RestauranteLLamada> response) {
            if (response.isSuccessful()){
                RestauranteLLamada restauranteLLamada = response.body();
                if (! restauranteLLamada.isError()){
                    porestauranteLLamada.getRestaurante()
                }

            }else{

            }

        }

        @Override
        public void onFailure(Call<RestauranteLLamada> call, Throwable t) {
           // Toast.makeText(getContext(),t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
        }
    }


}