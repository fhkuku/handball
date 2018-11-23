package com.handball.adapters;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.handball.R;
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
        View view = layoutInflater.inflate(R.layout.card_item, viewGroup, false);
        return new adpclub.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adpclub.MyViewHolder myViewHolder, int i) {

        Picasso.with(c).load(mData.get(i).getUrl()).resize(1200,555).into(myViewHolder.imgclub);

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
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        imgclub = itemView.findViewById(R.id.imgclub);
        }
    }


    @Override
    public void onViewAttachedToWindow(adpclub.MyViewHolder myViewHolder){
        try {
            super.onViewAttachedToWindow(myViewHolder);
            animated(myViewHolder.itemView);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void animated(View view){
        int CenterX =0;
        int CenterY =0;
        int start =0;
        int endRadius = Math.max(view.getWidth(),view.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(view, CenterX, CenterY,start, endRadius);
        view.setVisibility(View.VISIBLE);
        animator.start();
    }

}
