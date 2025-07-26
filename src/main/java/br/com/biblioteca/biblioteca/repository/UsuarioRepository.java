package br.com.biblioteca.biblioteca.repository;

import br.com.biblioteca.biblioteca.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {}
