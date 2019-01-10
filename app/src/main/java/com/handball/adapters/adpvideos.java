package com.handball.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.handball.R;
import com.handball.activitys.videos;
import com.handball.classes.clsvideos;

import java.util.ArrayList;

public class adpvideos extends RecyclerView.Adapter<adpvideos.MyViewHolder> {

    Context c;
    ArrayList<clsvideos> mData;


    public adpvideos(Context c, ArrayList<clsvideos> mData){
        this.c = c;
        this.mData = mData;

    }

    @NonNull
    @Override
    public adpvideos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View view = layoutInflater.inflate(R.layout.cardvideos, viewGroup, false);
        return new adpvideos.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adpvideos.MyViewHolder myViewHolder, int i) {
        myViewHolder.txt.setText(mData.get(i).getTitre());
        myViewHolder.btnvideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, videos.class);
                intent.putExtra("url", mData.get(i).getUrl());
                c.startActivity(intent);
                ((Activity)c).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ConstraintLayout btnvideos;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
            btnvideos = itemView.findViewById(R.id.btnvideos);


        }
    }
}
