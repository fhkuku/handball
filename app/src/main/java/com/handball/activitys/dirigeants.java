package com.handball.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.handball.R;
import com.handball.adapters.adphotos;
import com.handball.classes.activitys;
import com.handball.classes.elements;
import com.handball.classes.request;

public class dirigeants extends AppCompatActivity {

    com.handball.classes.elements e = new elements();
    activitys A = new activitys();
    request r = new request();
    adphotos p = new adphotos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dirigeants);
        e.conext = this;
        r.d = this;
        r.GetDirigeants();


    }
}
