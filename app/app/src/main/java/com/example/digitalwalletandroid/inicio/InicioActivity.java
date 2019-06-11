package com.example.digitalwalletandroid.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.MovimentacaoActivity;

public class InicioActivity extends AppCompatActivity {

    private Button iniciarBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        iniciarBotao = (Button) findViewById(R.id.iniciarButton);
        iniciarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarBotaoActivity();
            }
        });

    }

    private void iniciarBotaoActivity() {
        startActivity(new Intent(InicioActivity.this, MovimentacaoActivity.class));
    }


}
