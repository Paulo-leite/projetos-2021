package com.github.pauloleite.cursostringnelio.controller;

import com.github.pauloleite.cursostringnelio.model.Cidade;
import com.github.pauloleite.cursostringnelio.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> create(@RequestBody Cidade cidade) {
        Cidade obj = cidadeService.criar(cidade);
        return  new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> findAll() {
        List<Cidade> obj = cidadeService.listarTodos();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cidade> findForId(@PathVariable Integer id) {
        Cidade obj = cidadeService.listarPorId(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
