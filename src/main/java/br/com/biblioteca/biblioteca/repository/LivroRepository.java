package br.com.biblioteca.biblioteca.repository;

import br.com.biblioteca.biblioteca.entity.AutorEntity;
import br.com.biblioteca.biblioteca.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    @Query("SELECT e FROM LivroEntity e WHERE e.titulo LIKE %:titulo%")
    List<LivroEntity> findByNome(@Param("titulo") String titulo);

    List<LivroEntity> findByAtivoTrue();

}
