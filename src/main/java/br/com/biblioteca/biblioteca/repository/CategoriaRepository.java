package br.com.biblioteca.biblioteca.repository;

import br.com.biblioteca.biblioteca.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    List<CategoriaEntity> findByAtivoTrue();
}
