package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.autor.AutorPostDto;
import br.com.biblioteca.biblioteca.dto.autor.AutorPutDto;
import br.com.biblioteca.biblioteca.models.AutorModel;

import java.util.List;

public interface AutorService {

    AutorModel cadastrarAutor(AutorPostDto autorPostDto) throws Exception;
    AutorModel atualizarAutor(AutorPutDto autorPutDto) throws Exception;
    List<AutorModel> buscarTodosAutores();
    AutorModel buscarAutorPorId(Long id) throws Exception;
    AutorModel excluirAutor(Long id) throws Exception;
    List<AutorModel> buscarAutoresAtivos();
    List<AutorModel> buscarAutoresPorNome(String nome) throws Exception;
}
