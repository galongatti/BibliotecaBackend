package br.com.biblioteca.biblioteca.controller;

import br.com.biblioteca.biblioteca.dto.autor.AutorGetDto;
import br.com.biblioteca.biblioteca.dto.autor.AutorPostDto;
import br.com.biblioteca.biblioteca.dto.autor.AutorPutDto;
import br.com.biblioteca.biblioteca.models.AutorModel;
import br.com.biblioteca.biblioteca.response.Response;
import br.com.biblioteca.biblioteca.service.AutorService;
import br.com.biblioteca.biblioteca.service.AutorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorServiceImp autorService;

    @GetMapping("/")
    public ResponseEntity<Response<List<AutorGetDto>>> findAllAtivos() {
        Response<List<AutorGetDto>> response = new Response<>();
        try {
            List<AutorModel> autoresModel = autorService.buscarAutoresAtivos();
            List<AutorGetDto> autorGetDtos = autoresModel.stream().map(AutorModel::toGetDto).toList();
            response.setData(autorGetDtos);
            response.setMessage("Autores encontrados com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar autores: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<AutorGetDto>> findById(@PathVariable Long id) {
        Response<AutorGetDto> response = new Response<>();
        try {
            AutorModel autorModel = autorService.buscarAutorPorId(id);
            response.setData(autorModel.toGetDto());
            response.setMessage("Autor encontrado com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar autor: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Response<AutorGetDto>> cadastrarAutor(@RequestBody AutorPostDto autorPostDto) {
        Response<AutorGetDto> response = new Response<>();
        try {
            AutorModel autorModel = autorService.cadastrarAutor(autorPostDto);
            response.setData(autorModel.toGetDto());
            response.setMessage("Autor cadastrado com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao cadastrar autor: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Response<AutorGetDto>> atualizarAutor(@RequestBody AutorPutDto autorPutDto) {
        Response<AutorGetDto> response = new Response<>();
        try {
            AutorModel autorModel = autorService.atualizarAutor(autorPutDto);
            response.setData(autorModel.toGetDto());
            response.setMessage("Autor atualizado com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao atualizar autor: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<AutorGetDto>> excluirAutor(@PathVariable Long id) {
        Response<AutorGetDto> response = new Response<>();
        try {
            AutorModel autorModel = autorService.excluirAutor(id);
            response.setData(autorModel.toGetDto());
            response.setMessage("Autor excluído com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao excluir autor: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<Response<List<AutorGetDto>>> buscarAutoresPorNome(@RequestParam String nome) {
        Response<List<AutorGetDto>> response = new Response<>();
        try {

            List<AutorModel> autoresModel = autorService.buscarAutoresPorNome(nome);
            List<AutorGetDto> autorGetDtos = autoresModel.stream().map(AutorModel::toGetDto).toList();
            response.setData(autorGetDtos);
            response.setMessage("Autores encontrados com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar autor: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }
}