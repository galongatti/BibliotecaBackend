package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.categoria.CategoriaPostDto;
import br.com.biblioteca.biblioteca.dto.categoria.CategoriaPutDto;
import br.com.biblioteca.biblioteca.entity.CategoriaEntity;
import br.com.biblioteca.biblioteca.models.CategoriaModel;
import br.com.biblioteca.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaModel cadastrarCategoria(CategoriaPostDto categoriaPostDto) throws Exception {

        CategoriaModel categoriaModel = categoriaPostDto.toModel();
        categoriaModel.setAtivo(true);

        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaModel.toEntity());
        return categoriaEntity.toModel();
    }

    @Override
    public CategoriaModel atualizarCategoria(CategoriaPutDto categoriaPutDto) throws Exception {

        CategoriaModel categoriaExistente = this.buscarCategoriaPorId(categoriaPutDto.getId());
        if (categoriaExistente == null) {
            throw new Exception("Categoria não encontrada");
        }

        CategoriaModel categoriaModel = categoriaPutDto.toModel();
        categoriaModel.setAtivo(categoriaExistente.isAtivo());

        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaModel.toEntity());
        return categoriaEntity.toModel();
    }

    @Override
    public List<CategoriaModel> buscarTodasCategorias() {

        List<CategoriaEntity> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(CategoriaEntity::toModel)
                .toList();
    }

    @Override
    public CategoriaModel buscarCategoriaPorId(Long id) throws Exception {
        return categoriaRepository.findById(id)
                .map(CategoriaEntity::toModel)
                .orElseThrow(() -> new Exception("Categoria não encontrada com o ID: " + id));
    }

    @Override
    public CategoriaModel excluirCategoria(Long id) throws Exception {
        CategoriaModel categoriaExistente = this.buscarCategoriaPorId(id);
        if (categoriaExistente == null) {
            throw new Exception("Categoria não encontrada");
        }

        categoriaExistente.setAtivo(false);

        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaExistente.toEntity());
        return categoriaEntity.toModel();
    }

    @Override
    public List<CategoriaModel> buscarCategoriasAtivas() {

        return categoriaRepository.findByAtivoTrue()
                .stream()
                .map(CategoriaEntity::toModel)
                .toList();
    }
}
