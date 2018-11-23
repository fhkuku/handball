package com.handball.activitys;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.handball.R;
import com.handball.adapters.adphotos;
import com.handball.classes.activitys;
import com.handball.classes.elements;
import com.handball.classes.request;


public class photos extends AppCompatActivity  {

    com.handball.classes.elements e = new elements();
    activitys A = new activitys();
    request r = new request();
    adphotos p = new adphotos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        e.conext = this;
        A.context = this;
        p.p = this;
        r.p = this;
        r.Photos();
        r.GetPhotos();
        e.toolbar =  findViewById(R.id.toolbarphotos);

        setSupportActionBar(e.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        e.toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));


        e.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A.Menu();
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);




    }


    @Override
    public void onBackPressed() {
        A.Menu();
    }



}
