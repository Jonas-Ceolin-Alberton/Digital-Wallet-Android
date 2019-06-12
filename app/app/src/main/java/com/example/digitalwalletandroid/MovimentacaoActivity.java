package com.example.digitalwalletandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.main.MainActivity;
import com.example.digitalwalletandroid.movimentacoes.Movimentacao;
import com.example.digitalwalletandroid.origem.Origem;
import com.example.digitalwalletandroid.origem.OrigemService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovimentacaoActivity extends AppCompatActivity{

    private String tipoMovimentacao[];
    private String origems[];
    private Button salvarButton;
    private EditText valorEditText;

    private Spinner spinerTipoMovimentacao;
    private Spinner spinerTipoOrigem;

    private ArrayAdapter origemAdapter;
    private ArrayAdapter tipoMovimimentacaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentacao);

        // Cria o array com as opcoes de tipo de moviemtacao
        tipoMovimentacao = new String[2];
        tipoMovimentacao[0]="Receita";
        tipoMovimentacao[1]="Despesa";



        // atribui o array ao xml
        spinerTipoMovimentacao = (Spinner) findViewById(R.id.tipoMovSpinner);
        tipoMovimimentacaoAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tipoMovimentacao);
        tipoMovimimentacaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerTipoMovimentacao.setAdapter(tipoMovimimentacaoAdapter);

        // lista as origems
        buscarOrigems();


        // ouvir botao salvar click
        salvarButton =  findViewById(R.id.salvarButton);
        valorEditText = findViewById(R.id.valorEditText);
        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipo = spinerTipoMovimentacao.getSelectedItem().toString();
                String origem = spinerTipoOrigem.getSelectedItem().toString();
                String valor = valorEditText.getText().toString();

                Movimentacao movimentacao =  new Movimentacao();
//                movimentacao
            }
        });

    }

    public void buscarOrigems() {
        OrigemService service = new OrigemService();
        final Request request = service.getRequestGet();

        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {
                    JSONArray listaJSON =new JSONArray();
                    try {
                        listaJSON = new JSONArray(response.body().string());
                        atualizarOrigem(listaJSON);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private void atualizarOrigem(JSONArray listaJSON) {
        origems = new String[listaJSON.length()];
        try {
            for (int i = 0; i < listaJSON.length(); i++) {

                JSONObject jsonObject = listaJSON.getJSONObject(i);
                Integer id = Integer.parseInt(jsonObject.getString("id")) ;
                String nome = jsonObject.getString("nome");
                origems[i] = nome;
            }

            spinerTipoOrigem = (Spinner) findViewById(R.id.origemSpinner);
            origemAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, origems);
            origemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinerTipoOrigem.setAdapter(origemAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}