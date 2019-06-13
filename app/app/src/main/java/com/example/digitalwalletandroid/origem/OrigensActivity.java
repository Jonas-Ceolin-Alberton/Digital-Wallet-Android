package com.example.digitalwalletandroid.origem;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.movimentacoes.MovimentacaoActivity;
import com.example.digitalwalletandroid.movimentacoes.MovimentacoesActivity;

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

public class OrigensActivity extends AppCompatActivity {
    private  List<Origem> origens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.origem);

        FloatingActionButton fab = findViewById(R.id.fabOrigens);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrigensActivity.this, OrigemActivity.class));
            }
        });


        int layout = android.R.layout.simple_list_item_1;

        new BuscarOrigemsAsync().execute();



    }

    class BuscarOrigemsAsync extends AsyncTask<Void, Void, JSONArray> {
        @Override
        protected JSONArray doInBackground(Void... voids) {
            OrigemService service = new OrigemService();
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
            origens = new ArrayList<>();
            try {
                for (int i = 0; i < listaJSON.length(); i++) {

                    JSONObject jsonObject = listaJSON.getJSONObject(i);
                    Origem or = new Origem();
                    or.setId(Long.parseLong(jsonObject.getString("id")));
                    or.setNome(jsonObject.getString("nome"));

                    origens.add(or);
                }

                ListAdapter adapter = new OrigensAdapter(OrigensActivity.this, origens);

                ListView origensListView = findViewById(R.id.origensListView);

                origensListView.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
