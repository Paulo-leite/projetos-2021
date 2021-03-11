package com.github.pauloleite.cursostringnelio.service;

import com.github.pauloleite.cursostringnelio.model.Categoria;
import com.github.pauloleite.cursostringnelio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria criar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria listarPorId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return  categoria.orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
