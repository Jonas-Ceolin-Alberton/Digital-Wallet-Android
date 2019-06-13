package com.example.digitalwalletandroid.movimentacoes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.digitalwalletandroid.R;

import java.util.List;

public class MovimentacoesAdapter extends ArrayAdapter<Movimentacao> {

    public MovimentacoesAdapter(Context context, List<Movimentacao> objects) {
        super(context, R.layout.movimentacoes_layout, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View view = layoutInflater.inflate(R.layout.movimentacoes_layout, parent, false);

        Movimentacao movimentacao = getItem(position);

        TextView tipoMovimentacaoTextView = view.findViewById(R.id.tipoMovimentacaoTextView);
        tipoMovimentacaoTextView.setText(movimentacao.getTipoMovimentacao().toString());
//
//        TextView tipoOrigemTextView = view.findViewById(R.id.tipoOrigem);
//        tipoOrigemTextView.setText(movimentacao.getTipoOrigem().getNome());
////
//        TextView valorTextView = view.findViewById(R.id.valorTextView);
//        valorTextView.setText(movimentacao.getValor().toString());

        return view;
    }
}