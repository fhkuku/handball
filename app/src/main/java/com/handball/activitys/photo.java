package com.handball.activitys;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.handball.R;
import com.handball.classes.activitys;
import com.handball.classes.elements;
import com.squareup.picasso.Picasso;

public class photo extends AppCompatActivity {
    elements e = new elements();
    activitys A = new activitys();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        e.conext = this;
        A.context = this;
        setContentView(R.layout.activity_photo);
        e.Slide(this);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        e.extras = getIntent().getExtras();
        e.img = findViewById(R.id.img);
        if (e.extras!=null){
            try {
                String url = e.extras.getString("url");
                Picasso.with(this).load(url).resize(1200, 900).into(e.img);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void menu(View v){
        try {
            A.Photos();
        }catch (Exception e){
            e.printStackTrace();
        }

    }




}
