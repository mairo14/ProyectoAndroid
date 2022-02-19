package com.example.proyectoandroid;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListadoRes extends AppCompatActivity {

    static ArrayList<Cementerio> listado= new ArrayList<>();
    static ArrayList<Seleccionados> arrayMapa= new ArrayList<>();


    ListView listView;
    AdaptadorPersonalizado adaptador;
    TextView tipoDeBusqueda;
    TextView mostrarUsuario;
    Button salir;
    Button anteriorList;
    Button siguienteList;
    Double lati;
    Double longi;
    int pestaña = 0;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_res);
        listView = findViewById(R.id.listView);
        mostrarUsuario = findViewById(R.id.Usuario);
        salir = findViewById(R.id.Salir);
        tipoDeBusqueda = findViewById(R.id.Tipo);
        anteriorList = findViewById(R.id.Anterior);
        siguienteList = findViewById(R.id.Siguiente);

        Intent i = getIntent();
        String usuario = i.getStringExtra("usuario");
        String direccion = i.getStringExtra("direccion");
        lati = i.getDoubleExtra("latitud", 0);
        longi = i.getDoubleExtra("longitud", 0);
        mostrarUsuario.setText(direccion);
        arrayMapa.clear();

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListadoRes.this, MainActivity.class);

                startActivity(i);

            }
        });


        CrearLink(pestaña);
        anteriorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pestaña ==0){

                }else{
                    pestaña --;

                    CrearLink(pestaña);

                }

            }
        });
        siguienteList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pestaña == 2){

                    GoMapa();

                }else{
                    pestaña++;

                    CrearLink(pestaña);

                }

            }
        });


    }

    private void CrearLink(int caso){
        if(caso == 0){
            tipo = "piscinas";
            tipoDeBusqueda.setText(tipo);
            double latitud = lati;
            double longitud = longi;
            int distancia = 5000;
            String base = "https://datos.madrid.es/egob/catalogo/210227-0-piscinas-publicas.json?";
            String loc = "latitud=" + latitud +"&longitud="+ longitud+ "&distancia="+ distancia;
            LeerWS(base+loc+ "\n");
        }if(caso ==1){

            tipo = "Residencias";
            tipoDeBusqueda.setText(tipo);
            double latitud = lati;
            double longitud = longi;
            int distancia = 5000;
            String base = "https://datos.madrid.es/egob/catalogo/300048-0-ancianos-residencias-apartamento.json?";
            String loc = "latitud=" + latitud +"&longitud="+ longitud+ "&distancia="+ distancia;
            LeerWS(base+loc+ "\n");

        }if(caso ==2){
            tipo = "cementerios";
            tipoDeBusqueda.setText(tipo);
            double latitud = lati;
            double longitud = longi;
            int distancia = 5000;
            String base = "https://datos.madrid.es/egob/catalogo/205026-0-cementerios.json?";
            String loc = "latitud=" + latitud +"&longitud="+ longitud+ "&distancia="+ distancia;
            LeerWS(base+loc+ "\n");

        }


    }


    private void LeerWS(String url){

        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                listado.clear();

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
                                , arrayGraph.getJSONObject(i).getJSONObject("location").getDouble("longitude"),0
                        ));
                    }
                    for (int i = 0; i < listado.size(); i++) {
                       double lat =  listado.get(i).latitude;
                       int cercania = (int) (lat -lati);
                       listado.get(i).setCercania(cercania);

                    }
                    Collections.sort(listado, new Comparator<Cementerio>() {
                        @Override
                        public int compare(Cementerio p1, Cementerio p2) {
                            return new Integer(p1.getCercania()).compareTo(Integer.valueOf(p2.getCercania()));
                        }
                    });;
                  adaptador = new AdaptadorPersonalizado(ListadoRes.this, listado);
                  listView.setAdapter(adaptador);
                    seleccionarListado();

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


    //--------------------------------------------------------------------------------------------------------------------------------
    private void seleccionarListado() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_LONG).show();
                System.out.println("sout "+String.valueOf(i));


                view.setBackgroundColor(Color.RED);
                String titulo = listado.get(i).title;
                Double latParaArray = listado.get(i).latitude;
                Double lonParaArray = listado.get(i).longitude;


               arrayMapa.add(new Seleccionados(titulo, latParaArray, lonParaArray, tipo ));





            }
        });

    }
    private void GoMapa(){

        double latitud = lati;
        double longitud = longi;

        Intent intent = new Intent(ListadoRes.this,MapsActivity.class);
        //intent.putExtra("nombre", String.valueOf(listado.get(i).title));
        intent.putExtra("lat", Double.valueOf(latitud));
        intent.putExtra("lon", Double.valueOf(longitud));

        startActivity(intent);



    }





}