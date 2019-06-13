package com.example.digitalwalletandroid.origem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.movimentacoes.MovimentacaoActivity;
import com.example.digitalwalletandroid.movimentacoes.MovimentacoesActivity;

import java.util.Arrays;
import java.util.List;

public class OrigensActivity extends AppCompatActivity {

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

        Origem origem1 = new Origem();
        origem1.setNome("Compras");

        Origem origem2 = new Origem();
        origem2.setNome("Salário");

        Origem origem3 = new Origem();
        origem3.setNome("Depósito");

        List<Origem> origens = Arrays.asList(origem1, origem2, origem3);

        int layout = android.R.layout.simple_list_item_1;

        ListAdapter adapter = new OrigensAdapter(this, origens);

        ListView origensListView = findViewById(R.id.origensListView);

        origensListView.setAdapter(adapter);

    }

}
