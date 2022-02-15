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

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng posicion1 = new LatLng(40.472032763100025,-3.6406523385659426);
        // Add a marker in Sydney and move the camera
        LatLng localizacion1 = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(localizacion1).title(titulo));
        mMap.addMarker(new MarkerOptions().position(posicion1).title("Posicion actual"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(localizacion1));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(posicion1));

    }
}