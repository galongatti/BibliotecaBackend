package br.com.biblioteca.biblioteca.repository;

import br.com.biblioteca.biblioteca.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    List<AutorEntity> findByAtivoTrue();

    @Query("SELECT a FROM AutorEntity a WHERE a.nome LIKE %:nome%")
    List<AutorEntity> findByNome(@Param("nome") String nome);
}
