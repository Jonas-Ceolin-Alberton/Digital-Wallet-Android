package com.example.digitalwalletandroid.movimentacoes;


import com.example.digitalwalletandroid.origem.Origem;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MovimentacaoService  {
    String url = "http://192.168.0.103:8080";
    String PATH = "/movimentacoes";
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");

//
//
//    private RequestBody getJSON(Movimentacao movimentacao) {
////        JSONObject json = new JSONObject();
////
////        json.put("", "");
//
//        return RequestBody.create(JSON, "{\"tipoMovimentacao\": \"" +  +" \" }");
//    }
//
//    public Request getRequestGet(Origem origem) {
//        RequestBody rs = getJSON(origem);
//        return new Request.Builder()
//                .url(url.concat(PATH))
//                .post(rs)
//                .build();
//    }



}
