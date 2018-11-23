package com.handball.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

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
        r.GetClub();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }
}
