package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.editora.EditoraPostDto;
import br.com.biblioteca.biblioteca.dto.editora.EditoraPutDto;
import br.com.biblioteca.biblioteca.models.EditoraModel;

import java.util.List;

public interface EditoraService {
    EditoraModel cadastrarEditora(EditoraPostDto editoraPostDto) throws Exception;
    EditoraModel atualizarEditora(EditoraPutDto editoraPutDto) throws Exception;
    List<EditoraModel> buscarTodasEditoras();
    EditoraModel buscarEditoraPorId(Long id) throws Exception;
    EditoraModel excluirEditora(Long id) throws Exception;
}
