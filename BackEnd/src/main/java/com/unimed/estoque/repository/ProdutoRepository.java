package com.unimed.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unimed.estoque.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    
}
