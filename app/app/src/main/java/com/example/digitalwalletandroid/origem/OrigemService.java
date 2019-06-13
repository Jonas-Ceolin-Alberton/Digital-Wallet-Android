package com.example.digitalwalletandroid.origem;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OrigemService  {
    String url = "http://192.168.0.101:8080";
    String PATH = "/origem";
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    private RequestBody getJSON( Origem origem) {
        return RequestBody.create(JSON, "{\"nome\": \"" + origem.getNome() +" \" }");
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
