package com.digital.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.api.entity.Movimentacao;
import com.digital.api.services.MovimentacaoService;

@RestController
@RequestMapping(path = "/api/movimentacao")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping(path = "/receitas/{id}")
	public ResponseEntity<List<Movimentacao>> listarReceitasPorIdUsuario(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.body(this.movimentacaoService.listarReceitasPorUsuario(id));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<List<Movimentacao>> listarMovimentacoesPorUsuario(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.body(this.movimentacaoService.listarMovimentacoesPorUsuario(id));
	}
	

	@GetMapping(path = "/despesas/{id}")
	public ResponseEntity<List<Movimentacao>> listarDespesaPorIdUsuario(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.body(this.movimentacaoService.listarDespesasPorUsuario(id));
	}
	
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@PostMapping
	public Movimentacao salvar(@RequestBody Movimentacao movin) {
		return this.movimentacaoService.salvar(movin);
	}

	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@DeleteMapping(path = "/{id}")
	public boolean deletar(@PathVariable(name = "id") Long id) {
		return this.movimentacaoService.deletar(id);
	}
	
}
