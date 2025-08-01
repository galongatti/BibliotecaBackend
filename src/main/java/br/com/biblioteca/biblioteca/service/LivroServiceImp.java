package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.livro.LivroPostDto;
import br.com.biblioteca.biblioteca.dto.livro.LivroPutDto;
import br.com.biblioteca.biblioteca.entity.EditoraEntity;
import br.com.biblioteca.biblioteca.entity.LivroEntity;
import br.com.biblioteca.biblioteca.models.CategoriaModel;
import br.com.biblioteca.biblioteca.models.EditoraModel;
import br.com.biblioteca.biblioteca.models.LivroModel;
import br.com.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImp implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private EditoraService editoraService;


    @Override
    public LivroModel cadastrarLivro(LivroPostDto livroPostDto) throws Exception {

        EditoraModel editoraModel = editoraService.buscarEditoraPorId(livroPostDto.getCodigoEditora());
        if (editoraModel == null)
            throw new Exception("Editora não encontrada");

        CategoriaModel categoriaModel = categoriaService.buscarCategoriaPorId(livroPostDto.getCodigoCategoria());
        if (categoriaModel == null)
            throw new Exception("Categoria não encontrada");

        LivroModel livroModel = livroPostDto.toModel();
        livroModel.setEditora(editoraModel);
        livroModel.setCategoria(categoriaModel);
        livroModel.setAtivo(true);

        LivroEntity livroEntity = livroModel.toEntity();

        LivroEntity livroSalvo = livroRepository.save(livroEntity);
        return livroSalvo.toModel();
    }

    @Override
    public LivroModel atualizarLivro(LivroPutDto livroPutDto) throws Exception {

        LivroModel livroExistente = this.buscarLivroPorId(livroPutDto.getId());
        if (livroExistente == null)
            throw new Exception("Livro não encontrado");

        EditoraModel editoraModel = editoraService.buscarEditoraPorId(livroPutDto.getCodigoEditora());
        if (editoraModel == null)
            throw new Exception("Editora não encontrada");

        CategoriaModel categoriaModel = categoriaService.buscarCategoriaPorId(livroPutDto.getCodigoCategoria());
        if (categoriaModel == null)
            throw new Exception("Categoria não encontrada");

        LivroModel livroModel = livroPutDto.toModel();
        livroModel.setEditora(editoraModel);
        livroModel.setCategoria(categoriaModel);
        livroModel.setAtivo(livroExistente.isAtivo());

        LivroEntity livroEntity = livroModel.toEntity();

        LivroEntity livroSalvo = livroRepository.save(livroEntity);
        return livroSalvo.toModel();
    }

    @Override
    public LivroModel buscarLivroPorId(Long id) throws Exception {
        return livroRepository.findById(id)
                .map(LivroEntity::toModel)
                .orElseThrow(() -> new Exception("Livro não encontrado com o ID: " + id));
    }

    @Override
    public LivroModel excluirLivro(Long id) throws Exception {

        LivroModel livroModel = this.buscarLivroPorId(id);

        if(livroModel == null)
            throw new Exception("Livro não encontrado");

        livroModel.setAtivo(false);
        LivroEntity livroEntity = livroModel.toEntity();
        return livroRepository.save(livroEntity).toModel();
    }

    @Override
    public List<LivroModel> buscarTodosLivrosAtivos() {
        return livroRepository.findByAtivoTrue().stream().map(LivroEntity::toModel).toList();
    }

    @Override
    public List<LivroModel> buscarLivrosPorTitulo(String titulo) throws Exception {
        return livroRepository.findByNome(titulo).stream().map(LivroEntity::toModel).toList();
    }
}
