package com.github.pauloleite.cursostringnelio.controller;

import com.github.pauloleite.cursostringnelio.model.Produto;
import com.github.pauloleite.cursostringnelio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService  produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        Produto obj = produtoService.criar(produto);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listAll() {
        List<Produto> obj = produtoService.listarTodos();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findForId(@PathVariable Integer id) {
        Produto obj = produtoService.listarPorId(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
