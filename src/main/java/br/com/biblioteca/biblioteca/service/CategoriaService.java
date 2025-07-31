package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.categoria.CategoriaPostDto;
import br.com.biblioteca.biblioteca.dto.categoria.CategoriaPutDto;
import br.com.biblioteca.biblioteca.models.CategoriaModel;

import java.util.List;

public interface CategoriaService {

    CategoriaModel cadastrarCategoria(CategoriaPostDto categoriaPostDto) throws Exception;
    CategoriaModel atualizarCategoria(CategoriaPutDto categoriaPutDto) throws Exception;
    List<CategoriaModel> buscarTodasCategorias();
    CategoriaModel buscarCategoriaPorId(Long id) throws Exception;
    CategoriaModel excluirCategoria(Long id) throws Exception;
    List<CategoriaModel> buscarCategoriasAtivas();



}
