package com.example.digitalwalletandroid.origem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.digitalwalletandroid.R;

public class Origem extends AppCompatActivity {
    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.origem);



    }
}
