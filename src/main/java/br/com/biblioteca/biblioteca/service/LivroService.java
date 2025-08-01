package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.livro.LivroPostDto;
import br.com.biblioteca.biblioteca.dto.livro.LivroPutDto;
import br.com.biblioteca.biblioteca.models.LivroModel;

import java.util.List;

public interface LivroService {

    LivroModel cadastrarLivro(LivroPostDto livroPostDto) throws Exception;
    LivroModel atualizarLivro(LivroPutDto livroPutDto) throws Exception;
    LivroModel buscarLivroPorId(Long id) throws Exception;
    LivroModel excluirLivro(Long id) throws Exception;
    List<LivroModel> buscarTodosLivrosAtivos();
    List<LivroModel> buscarLivrosPorTitulo(String titulo) throws Exception;
}
