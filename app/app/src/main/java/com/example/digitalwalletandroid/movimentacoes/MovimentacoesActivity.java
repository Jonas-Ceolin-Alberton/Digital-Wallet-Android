package com.example.digitalwalletandroid.movimentacoes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.origem.Origem;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovimentacoesActivity extends AppCompatActivity {
   private List<Movimentacao> movimentacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movimentacao);

        FloatingActionButton fab = findViewById(R.id.fabMov);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MovimentacoesActivity.this, MovimentacaoActivity.class));
            }
        });

        int layout = android.R.layout.simple_list_item_1;

        new BuscarMovimentacoes().execute();
    }

    class BuscarMovimentacoes extends AsyncTask<Void, Void, JSONArray> {
        @Override
        protected JSONArray doInBackground(Void... voids) {
            MovimentacaoService service = new MovimentacaoService();
            final Request request = service.getRequestGet();

            OkHttpClient client = new OkHttpClient();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                return new JSONArray(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONArray listaJSON) {
            movimentacoes = new ArrayList<>();
            try {
                for (int i = 0; i < listaJSON.length(); i++) {

                    JSONObject jsonObject = listaJSON.getJSONObject(i);
                    JSONObject origem = jsonObject.getJSONObject("tipoOrigem");

                    Origem or = new Origem();
                    or.setId(Long.parseLong(origem.getString("id")));
                    or.setNome(origem.getString("nome"));

                    Movimentacao movimentacao = new Movimentacao();
                    movimentacao.setId(Long.parseLong(jsonObject.getString("id")));
                    Double db = Double.valueOf(Double.parseDouble(jsonObject.getString("valor")));
                    movimentacao.setValor(db);
                    movimentacao.setTipoOrigem(or);

                    String tipoMovimentacao = jsonObject.getString("tipoMovimentacao");
                    if(tipoMovimentacao.equals("DESPESA")) {
                        movimentacao.setTipoMovimentacao(Movimentacao.TipoMovimentacao.DESPESA);
                    } else {
                        movimentacao.setTipoMovimentacao(Movimentacao.TipoMovimentacao.RECEITA);
                    }



                    movimentacoes.add(movimentacao);
                }

                ListAdapter adapter = new MovimentacoesAdapter(MovimentacoesActivity.this, movimentacoes);

                ListView movimentacoesListView = findViewById(R.id.movimentacoesListView);

                movimentacoesListView.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
