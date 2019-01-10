package com.handball.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.handball.R;
import com.handball.classes.elements;

public class splash extends AppCompatActivity {


    elements e = new elements();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        e.img = findViewById(R.id.imglogo);
        e.txt = findViewById(R.id.txttitre);
        e.animation = AnimationUtils.loadAnimation(this, R.anim.zoom_forwad_in);
        e.img.setAnimation(e.animation);
        e.txt.setAnimation(e.animation);

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i = new Intent(getApplicationContext(), menu.class);
                    startActivity(i);
                }
            }
        }; timer.start();


    }
}
