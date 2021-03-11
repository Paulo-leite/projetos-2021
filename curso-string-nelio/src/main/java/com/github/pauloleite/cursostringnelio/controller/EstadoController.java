package com.github.pauloleite.cursostringnelio.controller;

import com.github.pauloleite.cursostringnelio.model.Cidade;
import com.github.pauloleite.cursostringnelio.model.Estado;
import com.github.pauloleite.cursostringnelio.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<Estado> create(@RequestBody Estado estado) {
        Estado obj = estadoService.criar(estado);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        List<Estado> obj = estadoService.listarTodos();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estado> findForId(@PathVariable Integer id) {
        Estado obj = estadoService.listarPorId(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
