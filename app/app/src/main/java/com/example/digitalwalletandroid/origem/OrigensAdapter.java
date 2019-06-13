package com.example.digitalwalletandroid.origem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.digitalwalletandroid.R;

import java.util.List;

public class OrigensAdapter extends ArrayAdapter<Origem> {

    public OrigensAdapter(Context context, List<Origem> objects) {
        super(context, R.layout.origens_layout, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View view = layoutInflater.inflate(R.layout.origens_layout, parent, false);

        Origem origem = getItem(position);

        TextView origemTextView = view.findViewById(R.id.origensTextView);
        origemTextView.setText(origem.getNome());

        return view;
    }
}
