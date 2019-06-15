package com.example.digitalwalletandroid.origem;

import android.graphics.drawable.Drawable;
import android.provider.SyncStateContract;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OrigemService  {
    String url = "http://172.20.10.7:8080";
    String PATH = "/origem";
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    private RequestBody getJSON( Origem origem) {
        Gson json =  new Gson();
        String body = json.toJson(origem);
        return RequestBody.create(JSON, body);
    }

    public Request getRequestPost(Origem origem) {
        RequestBody rs = getJSON(origem);
        return new Request.Builder()
                .url(url.concat(PATH))
                .post(rs)
                .build();
    }

    public Request getRequestGet() {
        return new Request.Builder()
                .url(url.concat(PATH))
                .get()
                .build();
    }




}
