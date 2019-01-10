package com.handball.activitys;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.handball.R;
import com.handball.classes.elements;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.maps.Style;
import com.squareup.picasso.Picasso;

public class showinfo extends AppCompatActivity {

    elements e = new elements();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinfo);
        e.txt = findViewById(R.id.txtnom);
        e.txtrol = findViewById(R.id.txtrol);
        e.imgUser = findViewById(R.id.img);
        e.btn = findViewById(R.id.button);



        Bundle data = getIntent().getExtras();
        if (data!=null){
            try {
                    e.txt.setText(data.getString("nom"));
                    e.txtrol.setText(data.getString("rol"));
                    Picasso.with(this).load(data.getString("img")).into(e.imgUser);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }




}
