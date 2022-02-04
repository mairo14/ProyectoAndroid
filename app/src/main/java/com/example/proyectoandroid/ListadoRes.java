package com.example.proyectoandroid;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ListadoRes extends AppCompatActivity {

    ArrayList<Cementerio> listado= new ArrayList<>();

    ListView listView;
    AdaptadorPersonalizado adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_res);
        listView = findViewById(R.id.listView);
        double latitud = 40.472032763100025;
        double longitud = -3.6406523385659426;
        int distancia = 5000;

        //   /catalogo/210227-0-piscinas-publicas.json
        //   /catalogo/300048-0-ancianos-residencias-apartamento.json
        //latitud=40.472032763100025&longitud=-3.6406523385659426&distancia=5000
        //https://datos.madrid.es/egob/catalogo/205026-0-cementerios.json?
        String base = "https://datos.madrid.es/egob/catalogo/300048-0-ancianos-residencias-apartamento.json?";
        String loc = "latitud=" + latitud +"&longitud="+ longitud+ "&distancia="+ distancia;
        LeerWS(base+loc+ "\n");



    }
    private void LeerWS(String url){

        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray arrayGraph = jsonObject.getJSONArray("@graph");
                    int contador = 0;
                    for (int i = 0; i < arrayGraph.length(); i++) {

                        contador++;
                        System.out.println(contador);
                        System.out.println(arrayGraph.getJSONObject(i).getString("title"));
                        System.out.println(arrayGraph.getJSONObject(i).getJSONObject("location").getDouble("latitude"));
                        System.out.println(arrayGraph.getJSONObject(i).getJSONObject("location").getDouble("longitude"));
                        listado.add(new Cementerio(arrayGraph.getJSONObject(i).getString("title")
                                , arrayGraph.getJSONObject(i).getJSONObject("location").getDouble("latitude")
                                , arrayGraph.getJSONObject(i).getJSONObject("location").getDouble("longitude")
                        ));
                    }
                    adaptador = new AdaptadorPersonalizado(ListadoRes.this, listado);
                    listView.setAdapter(adaptador);

                    //Title.setText(title);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        Volley.newRequestQueue(this).add(postRequest);

    }




}