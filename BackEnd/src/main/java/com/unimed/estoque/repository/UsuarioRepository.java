package com.unimed.estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unimed.estoque.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  Optional<Usuario> findByUsername(String username);
  Optional<Usuario> findByEmail(String email);


  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
