package com.example.proyectoandroid;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.proyectoandroid.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    ArrayList<Seleccionados> lista= new ArrayList<>();
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    double lon;
    double lat;
    String titulo;
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        lon = intent.getDoubleExtra("lon", 0);
        lat = intent.getDoubleExtra("lat", 0);
        titulo = intent.getStringExtra("nombre");
        lista = ListadoRes.arrayMapa;


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        volver  = findViewById(R.id.volver);
        LatLng posicion1 = new LatLng(lat,lon);

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MapsActivity.this , MarcarUbicacion.class);
                startActivity(i);
            }
        });
        mMap.addMarker(new MarkerOptions().position(posicion1).title("Posicion actual")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion1, 10));
        //mMap.zoo
        System.out.println("gdfgfdgfd");
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);



        for (int i = 0; i <(ListadoRes.arrayMapa).size(); i++) {
            System.out.println("pasa");


            LatLng localizacion = new LatLng(lista.get(i).latitude ,lista.get(i).longitude);
            System.out.println(i);
            String tipo = lista.get(i).tipo;


            if(tipo.equals("piscinas")){

                mMap.addMarker(new MarkerOptions().position(localizacion).title(lista.get(i).title)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            }if(tipo.equals("Residencias")){
                mMap.addMarker(new MarkerOptions().position(localizacion).title(lista.get(i).title)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

            }if (tipo.equals("cementerios")){
                mMap.addMarker(new MarkerOptions().position(localizacion).title(lista.get(i).title)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

            }



        }





       // mMap.moveCamera(CameraUpdateFactory.newLatLng(localizacion1));




    }
}