package com.example.proyectoandroid;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

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
    private void find(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://datos.madrid.es/egob/").addConverterFactory(GsonConverterFactory.create()).build();
        ProductoAPI productoAPI = retrofit.create(ProductoAPI.class);
        Call<List<Restaurante>> call = productoAPI.getPosts();
        call.enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if(!response.isSuccessful()){
                    tvejemplo.setText("Codigo "+response.code());
                    return;
                }
                List<Restaurante> List = response.body();
                for(Restaurante restaurante: List){
                    String content = "";
                    content += "id:"+ restaurante.getId()+"\n";
                    content += "title:"+ restaurante.getTitle()+"\n";
                    tvejemplo.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                    tvejemplo.setText(t.getMessage());
            }
        });
    }


}