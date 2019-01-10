package com.handball.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.handball.R;
import com.handball.classes.clsalles;
import com.handball.activitys.showinfoSalles;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adpsalles extends RecyclerView.Adapter<adpsalles.MyViewHolder> {


    Context c;
    ArrayList<clsalles> mData;
    public adpsalles(Context c, ArrayList<clsalles> mData){
        this.c = c;
        this.mData = mData;

    }

    @NonNull
    @Override
    public adpsalles.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View view = layoutInflater.inflate(R.layout.cardsalles, viewGroup, false);
        return new adpsalles.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adpsalles.MyViewHolder myViewHolder, int i) {
        try {
            Picasso.with(c).load(mData.get(i).getImg()).into(myViewHolder.img);
            myViewHolder.txtnom.setText(mData.get(i).getNom());
            myViewHolder.btn.setOnClickListener(v -> {
                Intent intent = new Intent(c, showinfoSalles.class);
                intent.putExtra("nom",mData.get(i).getNom());
                intent.putExtra("idclub", mData.get(i).getIdclub());
                intent.putExtra("img", mData.get(i).getImg());
                intent.putExtra("latitud",mData.get(i).getLatitud());
                intent.putExtra("longitud",mData.get(i).getLongitud());
                intent.putExtra("adresse", mData.get(i).getAdresse());
                c.startActivity(intent);
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtnom;
        ConstraintLayout btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
                img = itemView.findViewById(R.id.img);
                txtnom = itemView.findViewById(R.id.txtnom);
                btn = itemView.findViewById(R.id.btn);


        }
    }
}
