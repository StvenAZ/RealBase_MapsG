package com.example.realbase_mapsg;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Monitoring extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mapa;
    Marker marker;
    LatLng parquecentral;

    DatabaseReference coordinatesRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_monitoring);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        coordinatesRef = mDatabase.child("Coordenadas");

        coordinatesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                actualizarMarcadorMapa(snapshot.child("latitud").getValue(Double.class),
                        snapshot.child("longitud").getValue(Double.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        parquecentral = new LatLng(-1.02439623568, -79.466255739);
        CameraUpdate camUpd1 =
                CameraUpdateFactory
                        .newLatLngZoom(parquecentral, 15);

        mapa.moveCamera(camUpd1);


        mapa.addMarker(new MarkerOptions().position(parquecentral)
                .title("PARQUE CENTRAL"));

    }

    private void actualizarMarcadorMapa(double lat, double lng) {
        LatLng latLng = new LatLng(lat, lng);
        if (marker == null)
            marker = mapa.addMarker(new MarkerOptions().position(latLng).title("Tu Pos"));
        else
            marker.setPosition(latLng);

        mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }





}