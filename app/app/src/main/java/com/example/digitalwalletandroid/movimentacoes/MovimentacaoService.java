package com.example.digitalwalletandroid.movimentacoes;


import com.example.digitalwalletandroid.origem.Origem;
import com.google.gson.Gson;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MovimentacaoService  {
    String url = "http://192.168.0.101:8080";
    String PATH = "/movimentacoes";
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");



    private RequestBody getJSON(Movimentacao movimentacao) {
//        JSONObject json = new JSONObject();
//
//        json.put("", "");

        Gson json =  new Gson();
        String body = json.toJson(movimentacao);
        return RequestBody.create(JSON, body);
//        return RequestBody.create(JSON, "{\"tipoMovimentacao\": \"" + "DESPESA" +" \" }");
//                       + " }");
    }
//        + " \"valor\" : " + movimentacao.getValor().toString() + "\" ,"
//                      + "\" tipoOrigem\": {"
//                      + "\"nome\" : \"" + movimentacao.getTipoOrigem().getNome() + " \" } "

    public Request getRequestPost(Movimentacao movimentacao) {
        RequestBody rs = getJSON(movimentacao);

        return new Request.Builder()
                .url(url.concat(PATH))
                .post(rs)
                .build();
    }



}
