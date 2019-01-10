package com.handball.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
        Bundle datos = getIntent().getExtras();
        if (datos!=null){
            String id  = datos.getString("id");
            if (id.equals("1")|| id.equals("3")){
                r.GetDirigeants();
            }else if (id.equals("4")){
                r.GetSalles();
            }

        }



    }
}
