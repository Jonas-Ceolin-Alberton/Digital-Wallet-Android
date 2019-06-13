package com.example.digitalwalletandroid.movimentacoes;


import com.google.gson.Gson;


import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MovimentacaoService  {
    String url = "http://172.20.10.7:8080";
    String PATH = "/movimentacoes";
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");



    private RequestBody getJSON(Movimentacao movimentacao) {

        Gson json =  new Gson();
        String body = json.toJson(movimentacao);
        return RequestBody.create(JSON, body);
    }

    public Request getRequestPost(Movimentacao movimentacao) {
        RequestBody rs = getJSON(movimentacao);
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
