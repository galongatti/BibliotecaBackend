package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.autor.AutorPostDto;
import br.com.biblioteca.biblioteca.dto.autor.AutorPutDto;
import br.com.biblioteca.biblioteca.entity.AutorEntity;
import br.com.biblioteca.biblioteca.models.AutorModel;
import br.com.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImp implements AutorService{

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public AutorModel cadastrarAutor(AutorPostDto autorPostDto) throws Exception {

        AutorModel autorModel = autorPostDto.toModel();
        autorModel.setAtivo(true);

        AutorEntity autorEntity = autorRepository.save(autorModel.toEntity());

        return autorEntity.toModel();
    }

    @Override
    public AutorModel atualizarAutor(AutorPutDto autorPutDto) throws Exception {

        AutorModel autorExiste = this.buscarAutorPorId(autorPutDto.getId());

        if(autorExiste == null)
            throw new Exception("Autor não encontrado");

        AutorModel autorModel = autorPutDto.toModel();
        autorModel.setAtivo(autorExiste.isAtivo());

        AutorEntity autorEntity = autorRepository.save(autorModel.toEntity());
        return autorEntity.toModel();
    }

    @Override
    public List<AutorModel> buscarTodosAutores() {
        List<AutorEntity> autorEntities = autorRepository.findAll();
        return autorEntities.stream().map(AutorEntity::toModel).toList();
    }

    @Override
    public AutorModel buscarAutorPorId(Long id) throws Exception {
        return autorRepository.findById(id).map(AutorEntity::toModel)
                .orElseThrow(() -> new Exception("Autor não encontrado"));
    }

    @Override
    public AutorModel excluirAutor(Long id) throws Exception {
        AutorModel autorExiste = this.buscarAutorPorId(id);

        if(autorExiste == null)
            throw new Exception("Autor não encontrado");

        autorExiste.setAtivo(false);

        AutorEntity autorEntity = autorRepository.save(autorExiste.toEntity());
        return autorEntity.toModel();
    }

    @Override
    public List<AutorModel> buscarAutoresAtivos() {
        return autorRepository.findByAtivoTrue()
                .stream()
                .map(AutorEntity::toModel)
                .toList();
    }

    @Override
    public List<AutorModel> buscarAutoresPorNome(String nome) throws Exception {
        return autorRepository.findByNome(nome).stream().map(AutorEntity::toModel).toList();
    }
}
