package com.handball.adapters;
import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.handball.R;
import com.handball.activitys.photos;
import com.handball.classes.clsphotos;
import com.handball.classes.elements;
import com.handball.activitys.photo;
import com.squareup.picasso.Picasso;
import java.util.List;

public class adphotos extends RecyclerView.Adapter<adphotos.MyViewHolder> {

    private static Dialog dialog;
    private ImageView imgdialog;
    Transition transition;
    public photos p;
    elements e = new elements();
    FragmentManager fragmentManager;

    Context c;
    List<clsphotos> mData;

    public adphotos(){

    }
    public adphotos(Context c, List<clsphotos> mData){
        this.c = c;
        this.mData = mData;

    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            LayoutInflater layoutInflater = LayoutInflater.from(c);
            View view = layoutInflater.inflate(R.layout.cardphotos, viewGroup, false);
            return new adphotos.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {



        try {
            Picasso.with(c).load(mData.get(i).getUrl()).resize(950, 830).into(myViewHolder.imageView);
        }catch (Exception e){
            e.printStackTrace();
        }


        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    p = (photos) c;
                    Slide();
                    Transition(i);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        try {
            return mData.size();
        }catch (Exception e){
            e.printStackTrace();
            return mData.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            try {
                imageView = itemView.findViewById(R.id.imagenfotos);
                dialog = new Dialog(c);
                dialog.setContentView(R.layout.photosdialog);
                imgdialog = dialog.findViewById(R.id.imgphoto);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onViewAttachedToWindow(MyViewHolder myViewHolder){
        try {
            super.onViewAttachedToWindow(myViewHolder);
            animated(myViewHolder.itemView);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void animated(View view){
        try {
            int CenterX = 0;
            int CenterY = 0;
            int start = 0;
            int endRadius = Math.max(view.getWidth(), view.getHeight());
            Animator animator = ViewAnimationUtils.createCircularReveal(view, CenterX, CenterY, start, endRadius);
            view.setVisibility(View.VISIBLE);
            animator.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void Transition(int i){
        try {

            p.getWindow().setExitTransition(transition);
            Intent intent = new Intent(c, photo.class);
            intent.putExtra("url", mData.get(i).getUrl());
            c.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)c).toBundle());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Explode(){
        transition = new Explode();
    }

    public void Slide(){
        transition = new Slide(Gravity.LEFT);
    }

    public void onfade(){
        transition = new Fade(Fade.OUT);
    }

}
