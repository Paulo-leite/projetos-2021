package com.github.pauloleite.cursostringnelio.service;

import com.github.pauloleite.cursostringnelio.model.Cidade;
import com.github.pauloleite.cursostringnelio.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Cidade criar(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public List<Cidade> listarTodos() {
        return cidadeRepository.findAll();
    }

    public Cidade listarPorId(Integer id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        return cidade.orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
