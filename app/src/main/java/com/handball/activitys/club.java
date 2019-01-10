package com.handball.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.handball.R;
import com.handball.classes.elements;
import com.handball.classes.request;

public class club extends AppCompatActivity {

    elements e = new elements();
    request r = new request();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        e.conext = this;
        r.cl = this;
        e.img = findViewById(R.id.imgerror);
        e.img.setVisibility(View.INVISIBLE);
        r.GetClub();


    }
}
