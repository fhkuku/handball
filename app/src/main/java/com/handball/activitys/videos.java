package com.handball.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.handball.R;
import com.handball.classes.request;


public class videos extends YouTubeBaseActivity  implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    request r = new request();
    String claveYoutube = "AIzaSyBTPxawNOhM5__zxfDV647eLLQ-HNdhPME";
    YouTubePlayerView youTubePlayerView;
    String url = "Li6jvab0mVg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        r.v = this;
        r.GetVideos();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.idvideo);
        youTubePlayerView.initialize(claveYoutube, this);
        Bundle data = getIntent().getExtras();
        if (data!= null){
            url = data.getString("url");
        }



    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(url);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, 1).show();
        } else {
            String error = "error mija" + youTubeInitializationResult.toString();
            Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultcode, Intent data) {
        if (resultcode == 1) {
            getYoutubePlayerProvider().initialize(claveYoutube, this);
        }
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider() {
        return youTubePlayerView;
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
}



