package com.handball.classes;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.handball.activitys.photo;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;

public class elements implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    public CollapsingToolbarLayout collapsingToolbarLayout;
    public android.support.v7.widget.Toolbar toolbar;
    public CardView btnphotos, btnvideos, btnclub, btnequipes;
    public RecyclerView rcv;
    public String Url="https://gownetwork.com.mx/webservice/";
    public HashMap<String, String> HashMapForURL ;
    public SliderLayout sliderLayout;
    public static final int INTERVALLE = 2000;
    public long tempPremierClick;
    public Context conext;
    public VideoView videoView;
    public photo p;
    public Bundle extras;
    public ImageView img, imgback;
    public TextView txt;
    public Animation animation;
    public LinearLayout bottom_menu_shared;
    public FloatingActionButton btnShared;
    public BottomSheetBehavior behavior;
    public RequestParams request;



    public void showMensaje(String texto){
        Toast.makeText(conext, texto, Toast.LENGTH_SHORT).show();
    }

    public void Slider(HashMap<String, String> HashMapForURL){
        try {
            for (String name : HashMapForURL.keySet()) {
                TextSliderView textSliderView = new TextSliderView(conext);
                textSliderView
                        .description(name)
                        .image(HashMapForURL.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);
                sliderLayout.addSlider(textSliderView);
            }
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new DescriptionAnimation());
            sliderLayout.setDuration(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
