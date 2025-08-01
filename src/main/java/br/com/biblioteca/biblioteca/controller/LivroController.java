package br.com.biblioteca.biblioteca.controller;

import br.com.biblioteca.biblioteca.dto.livro.LivroGetDto;
import br.com.biblioteca.biblioteca.dto.livro.LivroPostDto;
import br.com.biblioteca.biblioteca.dto.livro.LivroPutDto;
import br.com.biblioteca.biblioteca.models.LivroModel;
import br.com.biblioteca.biblioteca.response.Response;
import br.com.biblioteca.biblioteca.service.LivroServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroServiceImp livroService;

    @GetMapping("/")
    public ResponseEntity<Response<List<LivroGetDto>>> findAll() {
        Response<List<LivroGetDto>> response = new Response<>();
        try {
            List<LivroModel> livrosModel = livroService.buscarTodosLivrosAtivos();
            List<LivroGetDto> livroGetDtos = livrosModel.stream().map(LivroModel::toGetDto).toList();
            response.setData(livroGetDtos);
            response.setMessage("Livros encontrados com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar livros: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<LivroGetDto>> findById(@PathVariable Long id) {
        Response<LivroGetDto> response = new Response<>();
        try {
            LivroModel livroModel = livroService.buscarLivroPorId(id);
            response.setData(livroModel.toGetDto());
            response.setMessage("Livro encontrado com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar livro: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Response<LivroGetDto>> cadastrarLivro(@RequestBody LivroPostDto livroPostDto) {
        Response<LivroGetDto> response = new Response<>();
        try {
            LivroModel livroModel = livroService.cadastrarLivro(livroPostDto);
            response.setData(livroModel.toGetDto());
            response.setMessage("Livro cadastrado com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao cadastrar livro: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Response<LivroGetDto>> atualizarLivro(@RequestBody LivroPutDto livroPutDto) {
        Response<LivroGetDto> response = new Response<>();
        try {
            LivroModel livroModel = livroService.atualizarLivro(livroPutDto);
            response.setData(livroModel.toGetDto());
            response.setMessage("Livro atualizado com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao atualizar livro: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<LivroGetDto>> excluirLivro(@PathVariable Long id) {
        Response<LivroGetDto> response = new Response<>();
        try {
            LivroModel livroModel = livroService.excluirLivro(id);
            response.setData(livroModel.toGetDto());
            response.setMessage("Livro excluído com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao excluir livro: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/buscarPorTitulo")
    public ResponseEntity<Response<List<LivroGetDto>>> buscarLivrosPorTitulo(@RequestParam String titulo) {
        Response<List<LivroGetDto>> response = new Response<>();
        try {
            List<LivroModel> livrosModel = livroService.buscarLivrosPorTitulo(titulo);
            List<LivroGetDto> livroGetDtos = livrosModel.stream().map(LivroModel::toGetDto).toList();
            response.setData(livroGetDtos);
            response.setMessage("Livros encontrados com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar livros: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }
}