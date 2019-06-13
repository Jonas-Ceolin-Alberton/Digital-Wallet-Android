package com.example.digitalwalletandroid.movimentacoes;

import com.example.digitalwalletandroid.origem.Origem;

public class Movimentacao{
    private Long id;
    private TipoMovimentacao tipoMovimentacao;
    private Origem tipoOrigem;
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
