package com.digital.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.api.entity.Movimentacao;
import com.digital.api.entity.Usuario;
import com.digital.api.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	public Movimentacao salvar(Movimentacao movi) {
		return this.movimentacaoRepository.save(movi);
	}
	
	public List<Movimentacao> listarReceitasPorUsuario(Long idUsuario) {
		return this.movimentacaoRepository.findByIdUsuarioAndTipoMovimentacao(idUsuario, "Receita");
	}
	
	public List<Movimentacao> listarDespesasPorUsuario(Long idUsuario) {
		return this.movimentacaoRepository.findByIdUsuarioAndTipoMovimentacao(idUsuario, "Despesa");
	}
	
	public List<Movimentacao> listarMovimentacoesPorUsuario(Long idUsuario) {
		return this.movimentacaoRepository.findByIdUsuario(idUsuario);
	}
	
	public boolean deletar(Long id) {
		this.movimentacaoRepository.deleteById(id);
		return 	true;
	}

}
