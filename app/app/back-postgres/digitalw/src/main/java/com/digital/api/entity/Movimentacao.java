package com.digital.api.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private TipoMovimentacao tipoMovimentacao;
	private Double valor;
	@OneToOne
	@JoinColumn
	private Origem tipoOrigem;

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public enum TipoMovimentacao {
		RECEITA, DESPESA
	}
}

