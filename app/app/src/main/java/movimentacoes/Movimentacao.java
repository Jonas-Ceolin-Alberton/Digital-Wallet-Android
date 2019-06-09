package movimentacoes;

import origem.Origem;

public class Movimentacao {
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
