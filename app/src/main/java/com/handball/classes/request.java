package com.handball.classes;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import com.handball.R;
import com.handball.activitys.club;
import com.handball.activitys.menu;
import com.handball.activitys.photos;
import com.handball.adapters.adpclub;
import com.handball.adapters.adpdirigeants;
import com.handball.adapters.adphotos;
import com.handball.activitys.dirigeants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class request extends  AsyncHttpClient {

    elements e = new elements();
    public Context c;
    public String s;
    public menu m;
    public photos p;
    public clsphotos photos;
    public club cl;
    public dirigeants d;


    public void menu(){
        try {
            e.conext = m;
            e.sliderLayout = m.findViewById(R.id.slider);
            e.collapsingToolbarLayout = m.findViewById(R.id.idcollapsing);
            e.collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.StyleAppBar);
            e.collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.StyleAppBar);
            e.collapsingToolbarLayout.setTitle("Handball de Danjoutin");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void GetSlidesMenu(){
        try {
            AsyncHttpClient client = new AsyncHttpClient();
            e.request = new RequestParams();
            e.request.put("data", "photos");
            client.post(e.Url + "Request.php",e.request, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    try {
                        JSONArray array = new JSONArray(new String(responseBody));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject row = array.getJSONObject(i);
                            String url = row.getString("url");
                            String description = row.getString("description");
                            e.HashMapForURL = new HashMap<>();
                            e.HashMapForURL.put(description, url);
                            e.Slider(e.HashMapForURL);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Photos(){
        try {
            e.conext = p;
            e.sliderLayout = p.findViewById(R.id.sliderphotos);
            e.collapsingToolbarLayout = p.findViewById(R.id.idcollapsing);
            e.collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.StyleAppBar);
            e.collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.StyleAppBar);
            e.collapsingToolbarLayout.setTitle("Photos");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void GetPhotos() {
        try {
            AsyncHttpClient client = new AsyncHttpClient();
            e.request = new RequestParams();
            e.request.put("data", "photos");
            client.post(e.Url + "Request.php", e.request , new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    ArrayList list = new ArrayList<>();
                    try {
                        JSONArray array = new JSONArray(new String(responseBody));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject row = array.getJSONObject(i);
                            e.HashMapForURL = new HashMap<>();
                            e.HashMapForURL.put(row.getString("description"), row.getString("url"));
                            e.Slider(e.HashMapForURL);
                            list.add(new clsphotos(row.getString("id"), row.getString("url")));
                            e.rcv = p.findViewById(R.id.rcvphotos);
                            adphotos m = new adphotos(p, list);
                            e.rcv.setLayoutManager(new GridLayoutManager(p, 2));
                            e.rcv.setAdapter(m);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void GetClub() {
        try {
            e.conext = cl;
            AsyncHttpClient client = new AsyncHttpClient();
            e.request = new RequestParams();
            e.request.put("data", "club");
            client.post(e.Url + "Request.php",e.request, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    ArrayList list = new ArrayList<>();
                    try {
                        JSONArray array = new JSONArray(new String(responseBody));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject row = array.getJSONObject(i);
                            list.add(new clsclub(row.getString("id"), row.getString("img"), row.getString("nom")));
                            e.rcv = cl.findViewById(R.id.rcvclub);
                            adpclub m = new adpclub(cl, list);
                            e.rcv.setLayoutManager(new GridLayoutManager(cl, 2));
                            e.rcv.setAdapter(m);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void GetDirigeants() {
        try {
            e.conext = d;
            Bundle datos = d.getIntent().getExtras();
            String id = datos.getString("id");
            AsyncHttpClient client = new AsyncHttpClient();
            e.request = new RequestParams();
            e.request.put("data", "dirigeants");
            e.request.put("id", id);
            client.post(e.Url + "Request.php",e.request, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    ArrayList list = new ArrayList<>();
                    try {
                        JSONArray array = new JSONArray(new String(responseBody));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject row = array.getJSONObject(i);
                            list.add(new clsdirigeants(row.getString("id"), row.getString("nom"), row.getString("img"), row.getString("email"), row.getString("idtype")));
                            e.rcv = d.findViewById(R.id.rcvdirigeants);
                            adpdirigeants m = new adpdirigeants(d, list);
                            e.rcv.setLayoutManager(new GridLayoutManager(d, 1));
                            e.rcv.setAdapter(m);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
