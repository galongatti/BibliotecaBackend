package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.editora.EditoraPostDto;
import br.com.biblioteca.biblioteca.dto.editora.EditoraPutDto;
import br.com.biblioteca.biblioteca.entity.EditoraEntity;
import br.com.biblioteca.biblioteca.models.EditoraModel;
import br.com.biblioteca.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraServiceImp implements EditoraService{


    @Autowired
    private EditoraRepository editoraRepository;

    @Override
    public EditoraModel cadastrarEditora(EditoraPostDto editoraPostDto) throws Exception {

        EditoraModel editoraModel = editoraPostDto.toModel();
        editoraModel.setAtivo(true);
        EditoraEntity editoraEntity = editoraRepository.save(editoraModel.toEntity());
        return editoraEntity.toModel();
    }

    @Override
    public EditoraModel atualizarEditora(EditoraPutDto editoraPutDto) throws Exception {

        EditoraModel editoraExistente = this.buscarEditoraPorId(editoraPutDto.getId());

        if(editoraExistente == null) {
            throw new Exception("Editora não encontrada");
        }

        EditoraModel editoraModel = editoraPutDto.toModel();

        EditoraEntity editoraEntity = editoraRepository.save(editoraModel.toEntity());
        return editoraEntity.toModel();
    }

    @Override
    public List<EditoraModel> buscarTodasEditoras() {
        List<EditoraEntity> editorasEntity = editoraRepository.findAll();
        return editorasEntity.stream().map(EditoraEntity::toModel).toList();
    }

    @Override
    public EditoraModel buscarEditoraPorId(Long id) throws Exception {
        Optional<EditoraEntity> editoraEntity = editoraRepository.findById(id);
        return editoraEntity.map(EditoraEntity::toModel)
                .orElseThrow(() -> new Exception("Editora não encontrada com o ID: " + id));
    }

    @Override
    public EditoraModel excluirEditora(Long id) throws Exception {
        EditoraModel editoraExiste = this.buscarEditoraPorId(id);

        if(editoraExiste == null) {
            throw new Exception("Editora não encontrada");
        }

        editoraExiste.setAtivo(false);

        EditoraEntity editoraEntity = editoraRepository.save(editoraExiste.toEntity());
        return editoraEntity.toModel();
    }
}
