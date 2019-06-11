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
@CrossOrigin
@RequestMapping(path = "/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService movimentacaoService;


	@GetMapping()
	public ResponseEntity<Iterable<Movimentacao>> buscarTodos() {
		return ResponseEntity.ok()
				.body(this.movimentacaoService.getAll());
	}
	
	@GetMapping(path = "/receitas")
	public ResponseEntity<List<Movimentacao>> buscarReceitas() {
		return ResponseEntity.ok()
				.body(this.movimentacaoService.getReceitas());
	}
	
	@GetMapping(path = "/despesas")
	public ResponseEntity<List<Movimentacao>> buscarDespesas() {
		return ResponseEntity.ok()
				.body(this.movimentacaoService.getDespesas());
	}

	@PostMapping
	public Movimentacao salvar(@RequestBody Movimentacao movimentacao) {
		return this.movimentacaoService.salvar(movimentacao);
	}
}
