package com.example.digitalwalletandroid.movimentacoes;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.main.MainActivity;
import com.example.digitalwalletandroid.movimentacoes.Movimentacao;
import com.example.digitalwalletandroid.origem.Origem;
import com.example.digitalwalletandroid.origem.OrigemActivity;
import com.example.digitalwalletandroid.origem.OrigemService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovimentacaoActivity extends AppCompatActivity {

    private String tipoMovimentacao[];
    private List<String> origemsString;
    private List<Origem> origemsObject;
    private Button salvarButton;
    private EditText valorEditText;

    private Spinner spinerTipoMovimentacao;
    private Spinner spinerTipoOrigem;

    private ArrayAdapter origemAdapter;
    private ArrayAdapter tipoMovimimentacaoAdapter;

    private Movimentacao movimentacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentacao);

        // Cria o array com as opcoes de tipo de moviemtacao
        tipoMovimentacao = new String[2];
        tipoMovimentacao[0] = "Receita";
        tipoMovimentacao[1] = "Despesa";


        // atribui o array ao xml
        spinerTipoMovimentacao = (Spinner) findViewById(R.id.tipoMovSpinner);
        tipoMovimimentacaoAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tipoMovimentacao);
        tipoMovimimentacaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerTipoMovimentacao.setAdapter(tipoMovimimentacaoAdapter);

        // lista as origems
        new BuscarOrigemsAsync().execute();


        // ouvir botao salvar click
        salvarButton = findViewById(R.id.salvarButton);
        valorEditText = findViewById(R.id.valorEditText);
        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicouBotao();
            }
        });


    }

    public void clicouBotao() {
        String tipo = spinerTipoMovimentacao.getSelectedItem().toString();
        String origem = spinerTipoOrigem.getSelectedItem().toString();
        String valor = valorEditText.getText().toString();

        Origem or = new Origem();

        for (Origem orig : origemsObject) {
            if (orig.getNome().equals(origem)) {
                or = orig;
            }
        }

        movimentacao = new Movimentacao();
        movimentacao.setValor(Double.valueOf(Double.parseDouble(valor)));
        movimentacao.setTipoOrigem(or);
        movimentacao.setTipoMovimentacao(Movimentacao.TipoMovimentacao.DESPESA);

        new SalvarMovimentacaoAsync().execute();
    }


    class SalvarMovimentacaoAsync extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(Void... voids) {
            MovimentacaoService service = new MovimentacaoService();
            final Request request = service.getRequestPost(movimentacao);

            OkHttpClient client = new OkHttpClient();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                return new JSONObject(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject listaJSON) {
            Toast.makeText(MovimentacaoActivity.this, "Movimentação salva!", Toast.LENGTH_SHORT).show();
        }
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
            origemsString = new ArrayList<>();
            origemsObject = new ArrayList<>();
            try {
                for (int i = 0; i < listaJSON.length(); i++) {

                    JSONObject jsonObject = listaJSON.getJSONObject(i);
                    Origem or = new Origem();
                    or.setId(Long.parseLong(jsonObject.getString("id")));
                    or.setNome(jsonObject.getString("nome"));

                    origemsString.add(or.getNome());
                    origemsObject.add(or);
                }

                spinerTipoOrigem = (Spinner) findViewById(R.id.origemSpinner);
                origemAdapter = new ArrayAdapter(MovimentacaoActivity.this, android.R.layout.simple_spinner_item, origemsString);
                origemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinerTipoOrigem.setAdapter(origemAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
