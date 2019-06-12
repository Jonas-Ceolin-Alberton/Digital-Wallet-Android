package com.example.digitalwalletandroid.origem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.digitalwalletandroid.R;

import java.util.Arrays;
import java.util.List;

public class OrigensActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.origem);

        Origem origem1 = new Origem();
        Origem origem2 = new Origem();
        Origem origem3 = new Origem();

        List<Origem> desenhos = Arrays.asList(
                origem1, origem2, origem3);

        int layout = android.R.layout.simple_list_item_1;

        ListAdapter adapter = new OrigensAdapter(this, desenhos);

        ListView origensListView = findViewById(R.id.origensListView);

        origensListView.setAdapter(adapter);

    }

}
