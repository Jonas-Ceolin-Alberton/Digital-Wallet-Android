package com.example.digitalwalletandroid.movimentacoes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.digitalwalletandroid.R;

import java.util.Arrays;
import java.util.List;

public class MovimentacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movimentacao);

        Movimentacao mov1 = new Movimentacao(1);
        Movimentacao mov2 = new Movimentacao(2);
        Movimentacao mov3 = new Movimentacao(3);

        List<Movimentacao> movimentacoes = Arrays.asList(mov1, mov2, mov3);

        int layout = android.R.layout.simple_list_item_1;

        ListAdapter adapter = new MovimentacoesAdapter(this, movimentacoes);

        ListView movimentacoesListView = findViewById(R.id.movimentacoesListView);

        movimentacoesListView.setAdapter(adapter);

    }

}
