package com.example.digitalwallet;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import movimentacoes.MovimentacaoActivity;

public class MainActivity extends AppCompatActivity {

    private Button iniciarBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarBotao = (Button) findViewById(R.id.iniciarButton);
        iniciarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarBotaoActivity();
            }
        });

    }

    private void iniciarBotaoActivity() {
        startActivity(new Intent(MainActivity.this, MovimentacaoActivity.class));
    }

}
