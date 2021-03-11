package com.github.pauloleite.cursostringnelio.service;

import com.github.pauloleite.cursostringnelio.model.Estado;
import com.github.pauloleite.cursostringnelio.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private EstadoRepository estadoRepository;

    @Autowired
    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public Estado criar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> listarTodos() {
        return estadoRepository.findAll();
    }

    public Estado listarPorId(Integer id) {
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
