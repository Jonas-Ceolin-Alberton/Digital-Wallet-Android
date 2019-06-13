package com.example.digitalwalletandroid.origem;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.digitalwalletandroid.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OrigemActivity extends AppCompatActivity {
    private EditText nomeEditText;
    private Button salvarButton;

    private Origem origem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origem);

        nomeEditText = findViewById(R.id.nomeOrigemEditText);
        salvarButton = findViewById(R.id.salvarButton);

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarOrigem();
            }
        });
    }

    private void salvarOrigem() {
        origem = new Origem();
        origem.setNome(nomeEditText.getText().toString());
        new SalvarOrigemAsync().execute();
    }

    class SalvarOrigemAsync extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(Void... voids) {
            OrigemService service = new OrigemService();
            final Request request = service.getRequestPost(origem);

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
            listaJSON.length();
        }
    }
}
