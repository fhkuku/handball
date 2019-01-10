package com.handball.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.handball.R;
import com.handball.activitys.showinfo;
import com.handball.classes.clsdirigeants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adpdirigeants extends RecyclerView.Adapter<adpdirigeants.MyViewHolder> {

    ArrayList<clsdirigeants> mData;
    Context c;

    public adpdirigeants(Context c, ArrayList<clsdirigeants> mData){
        this.c = c;
        this.mData = mData;

    }

    @NonNull
    @Override
    public adpdirigeants.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        try {
            LayoutInflater layoutInflater = LayoutInflater.from(c);
            View view = layoutInflater.inflate(R.layout.cardirigeants, viewGroup, false);
            return new adpdirigeants.MyViewHolder(view);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull adpdirigeants.MyViewHolder myViewHolder, final int i) {
        try {
            Picasso.with(c).load(mData.get(i).getImg()).into(myViewHolder.img);
            myViewHolder.txtnom.setText(mData.get(i).getNom());
            myViewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(c, showinfo.class);
                    intent.putExtra("id", mData.get(i).getId());
                    intent.putExtra("nom", mData.get(i).getNom());
                    intent.putExtra("img", mData.get(i).getImg());
                    intent.putExtra("email", mData.get(i).getEmail());
                    intent.putExtra("idtype", mData.get(i).getIdtype());
                    intent.putExtra("rol", mData.get(i).getRol());
                    intent.putExtra("idclub", mData.get(i).getIdclub());
                    c.startActivity(intent);
                }
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
        Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtnom = itemView.findViewById(R.id.txtnom);
            btn = itemView.findViewById(R.id.btnclub);
        }
    }
}
