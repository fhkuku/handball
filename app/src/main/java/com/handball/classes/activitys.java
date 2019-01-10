package com.handball.classes;

import android.content.Context;
import android.content.Intent;

import com.handball.activitys.club;
import com.handball.activitys.menu;
import com.handball.activitys.photos;
import com.handball.activitys.videos;
import com.handball.activitys.contact;


public class activitys {
    public Context context;

       public void Photos(){
        try{
            Intent intent = new Intent(context, photos.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Menu(){
        try{
            Intent intent = new Intent(context, menu.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Videos(){
        try{
            Intent intent = new Intent(context, videos.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Club(){
        try{
            Intent intent = new Intent(context, club.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void Contact(){
           try{
               Intent intent = new Intent(context, contact.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               context.startActivity(intent);

           }catch (Exception e){
               e.printStackTrace();
           }


    }


}
