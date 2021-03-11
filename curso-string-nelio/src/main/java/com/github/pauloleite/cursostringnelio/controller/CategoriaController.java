package com.github.pauloleite.cursostringnelio.controller;

import com.github.pauloleite.cursostringnelio.model.Categoria;
import com.github.pauloleite.cursostringnelio.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        Categoria obj = categoriaService.criar(categoria);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> obj = categoriaService.listarTodos();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findForId(@PathVariable Integer id) {
        Categoria obj = categoriaService.listarPorId(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }


}
