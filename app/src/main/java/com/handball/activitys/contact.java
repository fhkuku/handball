package com.handball.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.handball.R;
import com.handball.classes.elements;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.maps.Style;

public class contact extends AppCompatActivity {

    elements e = new elements();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, e.KEY_MAP);
        setContentView(R.layout.activity_contact);

        com.mapbox.mapboxsdk.geometry.LatLng office = new com.mapbox.mapboxsdk.geometry.LatLng(47.646891, 6.8741397);
        e.m = findViewById(R.id.mapView);
        e.m.onCreate(savedInstanceState);
        e.m.getMapAsync(mapboxMap ->
                mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {
                    mapboxMap.addMarker(new MarkerOptions().position(office).title("HandBall de Danjoutin"));
                    mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(office, 13));

                })
        );
    }

    @Override
    public void onStart() {
        super.onStart();
        e.m.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        e.m.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        e.m.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        e.m.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        e.m.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        e.m.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        e.m.onSaveInstanceState(outState);
    }
}
