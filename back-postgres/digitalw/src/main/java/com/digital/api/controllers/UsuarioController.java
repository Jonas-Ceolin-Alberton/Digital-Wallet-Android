package com.digital.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.api.entity.Usuario;
import com.digital.api.services.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Usuario>> listarPorId(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.body(this.usuarioService.buscarPorId(id));
	}
	
	@PostMapping
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		return this.usuarioService.salvar(usuario);
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@PostMapping(path= "/autenticar")
	public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario) {
		return ResponseEntity.ok()
				.body(this.usuarioService.autenticar(usuario));
	}
	
	
	
}
