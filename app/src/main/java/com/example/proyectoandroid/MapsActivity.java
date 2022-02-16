package com.example.proyectoandroid;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.proyectoandroid.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    ArrayList<Cementerio> lista= new ArrayList<>();
    ListadoRes listadoRes= new ListadoRes();
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    double lon;
    double lat;
    String titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        lon = intent.getDoubleExtra("lon", 0);
        lat = intent.getDoubleExtra("lat", 0);
        titulo = intent.getStringExtra("nombre");
        lista = listadoRes.listado;


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng posicion1 = new LatLng(lat,lon);
        System.out.println(lista.get(0).title);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        for (int i = 0; i <10; i++) {
            System.out.println("pasa");

            LatLng localizacion = new LatLng(lista.get(i).latitude ,lista.get(i).longitude);
            System.out.println(i);
            mMap.addMarker(new MarkerOptions().position(localizacion).title(lista.get(i).title));
        }




        mMap.addMarker(new MarkerOptions().position(posicion1).title("Posicion actual"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(localizacion1));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(posicion1));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));



    }
}