package com.handball.activitys;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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
        setContentView(R.layout.activity_photo);
        e.conext = this;
        A.context = this;
        e.bottom_menu_shared = (LinearLayout) findViewById(R.id.bottom_menu_shared);
        e.behavior = BottomSheetBehavior.from(e.bottom_menu_shared);
        e.behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        e.btnShared = findViewById(R.id.btnshared);

        e.extras = getIntent().getExtras();
        e.img = findViewById(R.id.img);
        if (e.extras!=null){
            try {
                String url = e.extras.getString("url");
                Picasso.with(this).load(url).resize(900, 820).into(e.img);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        e.btnShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

    }

    public void menu(View v){
        try {
            A.Photos();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
