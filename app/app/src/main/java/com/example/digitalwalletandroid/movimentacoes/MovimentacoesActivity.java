package com.example.digitalwalletandroid.movimentacoes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.origem.Origem;

import java.util.Arrays;
import java.util.List;

public class MovimentacoesActivity extends AppCompatActivity {

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

        Movimentacao mov1 = new Movimentacao();
        mov1.setTipoMovimentacao(Movimentacao.TipoMovimentacao.RECEITA);
        mov1.setTipoOrigem(new Origem("Salário"));
        mov1.setValor(1.0d);

        Movimentacao mov2 = new Movimentacao();
        mov2.setTipoMovimentacao(Movimentacao.TipoMovimentacao.DESPESA);
        mov2.setTipoOrigem(new Origem("Compras"));
        mov2.setValor(2.0d);

        Movimentacao mov3 = new Movimentacao();
        mov3.setTipoMovimentacao(Movimentacao.TipoMovimentacao.DESPESA);
        mov3.setTipoOrigem(new Origem("Mecânico"));
        mov3.setValor(3.0d);

        List<Movimentacao> movimentacoes = Arrays.asList(mov1, mov2, mov3);

        int layout = android.R.layout.simple_list_item_1;

        ListAdapter adapter = new MovimentacoesAdapter(this, movimentacoes);

        ListView movimentacoesListView = findViewById(R.id.movimentacoesListView);

        movimentacoesListView.setAdapter(adapter);

    }

}
