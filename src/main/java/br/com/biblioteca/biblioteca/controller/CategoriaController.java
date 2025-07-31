package br.com.biblioteca.biblioteca.controller;


import br.com.biblioteca.biblioteca.dto.categoria.CategoriaGetDto;
import br.com.biblioteca.biblioteca.dto.categoria.CategoriaPostDto;
import br.com.biblioteca.biblioteca.dto.categoria.CategoriaPutDto;
import br.com.biblioteca.biblioteca.entity.CategoriaEntity;
import br.com.biblioteca.biblioteca.models.CategoriaModel;
import br.com.biblioteca.biblioteca.response.Response;
import br.com.biblioteca.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<Response<List<CategoriaGetDto>>> findAll() {
        Response<List<CategoriaGetDto>> response = new Response<>();
        try {

            List<CategoriaModel> categoriasModel = categoriaService.buscarCategoriasAtivas();

            List<CategoriaGetDto> categoriaGetDtos = categoriasModel.stream().map(CategoriaModel::toGetDto).toList();

            response.setData(categoriaGetDtos);
            response.setMessage("Categorias encontradas com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar categorias: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<CategoriaGetDto>> findById(Long id) {
        Response<CategoriaGetDto> response = new Response<>();
        try {
            CategoriaModel categoriaModel = categoriaService.buscarCategoriaPorId(id);
            response.setData(categoriaModel.toGetDto());
            response.setMessage("Categoria encontrada com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar categoria: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Response<CategoriaGetDto>> cadastrarCategoria(@RequestBody CategoriaPostDto categoriaPostDto) {
        Response<CategoriaGetDto> response = new Response<>();
        try {
            CategoriaModel categoriaModel = categoriaService.cadastrarCategoria(categoriaPostDto);
            response.setData(categoriaModel.toGetDto());
            response.setMessage("Categoria cadastrada com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao cadastrar categoria: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Response<CategoriaGetDto>> atualizarCategoria(@RequestBody CategoriaPutDto categoriaPutDto) {
        Response<CategoriaGetDto> response = new Response<>();

        try {
            CategoriaModel categoriaModel = categoriaService.atualizarCategoria(categoriaPutDto);
            response.setData(categoriaModel.toGetDto());
            response.setMessage("Categoria atualizada com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            response.setData(null);
            response.setMessage("Erro ao atualizar categoria: " + exception.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<CategoriaGetDto>> excluirCategoria(Long id) {
        Response<CategoriaGetDto> response = new Response<>();
        try {
            CategoriaModel categoriaModel = categoriaService.excluirCategoria(id);
            response.setData(categoriaModel.toGetDto());
            response.setMessage("Categoria excluida com sucesso");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao excluir categoria: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }


}
