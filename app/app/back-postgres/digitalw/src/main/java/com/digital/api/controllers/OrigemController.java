package com.digital.api.controllers;

import com.digital.api.entity.Origem;
import com.digital.api.services.OrigemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/origem")
public class OrigemController {

    @Autowired
    private OrigemService origemService;


    @GetMapping()
    public ResponseEntity<Iterable<Origem>> buscarTodos() {
        return ResponseEntity.ok()
                .body(this.origemService.getAll());
    }

    @PostMapping
    public Origem salvar(@RequestBody Origem origem) {
        return this.origemService.salvar(origem);
    }
}
