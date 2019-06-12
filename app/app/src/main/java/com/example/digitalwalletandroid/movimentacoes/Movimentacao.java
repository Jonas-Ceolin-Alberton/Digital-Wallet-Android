package com.example.digitalwalletandroid.movimentacoes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.origem.Origem;

public class Movimentacao{
    private Integer id;
    private TipoMovimentacao tipoMovimentacao;
    private Origem tipoOrigem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Origem getTipoOrigem() {
        return tipoOrigem;
    }

    public void setTipoOrigem(Origem tipoOrigem) {
        this.tipoOrigem = tipoOrigem;
    }

    public enum TipoMovimentacao {
       RECEITA, DESPESA
    }

}
