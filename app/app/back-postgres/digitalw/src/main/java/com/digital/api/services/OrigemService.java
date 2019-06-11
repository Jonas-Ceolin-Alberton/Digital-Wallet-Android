package com.digital.api.services;

import com.digital.api.entity.Origem;
import com.digital.api.repositories.OrigemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrigemService {

    @Autowired
    public OrigemRepository origemRepository;

    public Origem salvar(Origem origem) {
        return origemRepository.save(origem);
    }

    public Optional<Origem> getById(Long id) {
        return origemRepository.findById(id);
    }

    public Iterable<Origem> getAll() {
        return origemRepository.findAll();
    }
}
