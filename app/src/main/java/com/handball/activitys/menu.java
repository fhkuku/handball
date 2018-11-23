package com.handball.activitys;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.handball.R;
import com.handball.classes.activitys;
import com.handball.classes.elements;
import com.handball.classes.request;

public class menu extends AppCompatActivity  {


    com.handball.classes.elements e = new elements();
    activitys A = new activitys();
    request r = new request();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        e.sliderLayout = findViewById(R.id.slider);
        e.conext = this;
        A.context = this;
        r.m = this;
        r.menu();
        r.GetSlidesMenu();

    }

    public void photos(View v){
        try{
            A.Photos();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void Videos(View v){
        try{
            A.Videos();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void Club(View v){
        try{
            A.Club();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Override
    public void onBackPressed(){
        try{
            if (e.tempPremierClick + elements.INTERVALLE > System.currentTimeMillis()){
                finishAffinity();
                return;
            }else {
                e.showMensaje("appuyez à nouveau pour sortir");
            }
            e.tempPremierClick = System.currentTimeMillis();
        }catch (Exception ex){
            ex.printStackTrace();
            e.showMensaje("erreur");
        }
    }


}
