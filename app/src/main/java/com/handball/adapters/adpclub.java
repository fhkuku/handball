package com.handball.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.handball.R;
import com.handball.activitys.dirigeants;
import com.handball.classes.clsclub;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adpclub extends RecyclerView.Adapter<adpclub.MyViewHolder> {

    Context c;
    List<clsclub> mData;
    public adpclub(Context c, List<clsclub> mData){
        this.c = c;
        this.mData = mData;
    }

    @NonNull
    @Override
    public adpclub.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View view = layoutInflater.inflate(R.layout.cardclub, viewGroup, false);
        return new adpclub.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adpclub.MyViewHolder myViewHolder, final int i) {
        try {

            Picasso.with(c).load(mData.get(i).getUrl()).resize(890, 750).into(myViewHolder.imgclub);
            myViewHolder.txtitre.setText(mData.get(i).getNom());
            myViewHolder.btnclub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(c, dirigeants.class);
                    intent.putExtra("id", mData.get(i).getIdclub());
                    c.startActivity(intent);
                }
            });



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        try {
            return mData.size();
        }catch (Exception e){
            return mData.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgclub;
        TextView txtitre;
        CardView btnclub;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgclub = itemView.findViewById(R.id.imgclub);
            txtitre = itemView.findViewById(R.id.txttitre);
            btnclub = itemView.findViewById(R.id.btnclub);
        }
    }



}
