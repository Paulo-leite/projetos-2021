package com.github.pauloleite.cursostringnelio.repository;

import com.github.pauloleite.cursostringnelio.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
