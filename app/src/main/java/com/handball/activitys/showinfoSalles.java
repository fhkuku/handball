package com.handball.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.handball.R;
import com.handball.classes.elements;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.maps.Style;
import com.squareup.picasso.Picasso;

public class showinfoSalles extends AppCompatActivity {

    elements e = new elements();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, e.KEY_MAP);
        setContentView(R.layout.activity_showinfo_salles);
        e.imgUser = findViewById(R.id.imgsalle);
        e.txt = findViewById(R.id.txtnom);
        e.txtrol = findViewById(R.id.txtadresse);


        Bundle data = getIntent().getExtras();
        if (data!=null){

            double lat = Double.valueOf(data.getString("latitud"));
            double lon = Double.valueOf(data.getString("longitud"));
            String img = data.getString("img");
            e.txt.setText(data.getString("nom"));
            e.txtrol.setText(data.getString("adresse"));

            Picasso.with(this).load(img).resize(1200,800).into(e.imgUser);
            com.mapbox.mapboxsdk.geometry.LatLng office = new com.mapbox.mapboxsdk.geometry.LatLng(lat, lon);
            e.m = findViewById(R.id.mapView);
            e.m.onCreate(savedInstanceState);
            e.m.getMapAsync(mapboxMap ->
                    mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {
                        mapboxMap.addMarker(new MarkerOptions().position(office).title(data.getString("nom")));
                        mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(office, 13));

                    })
            );
            e.m.setVisibility(View.VISIBLE);


        }
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
