package br.com.biblioteca.biblioteca.controller;


import br.com.biblioteca.biblioteca.dto.editora.EditoraGetDto;
import br.com.biblioteca.biblioteca.dto.editora.EditoraPostDto;
import br.com.biblioteca.biblioteca.dto.editora.EditoraPutDto;
import br.com.biblioteca.biblioteca.models.EditoraModel;
import br.com.biblioteca.biblioteca.response.Response;
import br.com.biblioteca.biblioteca.service.EditoraService;
import br.com.biblioteca.biblioteca.service.EditoraServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("editoras")
public class EditoraController {

    @Autowired
    private EditoraServiceImp editoraService;


    @PostMapping("/")
    public ResponseEntity<Response<EditoraGetDto>> cadastrarEditora(@RequestBody EditoraPostDto editoraGetDto) {

        Response<EditoraGetDto> response = new Response<>();
        try {

            EditoraModel editoraModel = editoraService.cadastrarEditora(editoraGetDto);
            response.setData(editoraModel.toGetDto());
            response.setMessage("Sucesso ao cadastrar editora");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao cadastrar editora: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Response<EditoraGetDto>> atualizarEditora(@RequestBody EditoraPutDto editoraPutDto) {

        Response<EditoraGetDto> response = new Response<>();
        try {
            EditoraModel editoraModel = editoraService.atualizarEditora(editoraPutDto);
            response.setData(editoraModel.toGetDto());
            response.setMessage("Sucesso ao atualizar editora");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao atualizar editora: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<EditoraGetDto>>> buscarTodasEditoras() {

        Response<List<EditoraGetDto>> response = new Response<>();
        try {

            List<EditoraModel> editoras = editoraService.buscarTodasEditoras();
            List<EditoraGetDto> editorasGetDto = editoras.stream()
                    .map(EditoraModel::toGetDto)
                    .toList();

            response.setData(editorasGetDto);
            response.setMessage("Sucesso ao buscar todas as editoras");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar editoras: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<EditoraGetDto>> buscarEditoraPorId(@PathVariable Long id) {

        Response<EditoraGetDto> response = new Response<>();
        try {
            EditoraModel editoraModel = editoraService.buscarEditoraPorId(id);
            response.setData(editoraModel.toGetDto());
            response.setMessage("Sucesso ao buscar editora por ID");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao buscar editora por ID: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<EditoraGetDto>> excluirEditora(@PathVariable Long id) {

        Response<EditoraGetDto> response = new Response<>();
        try {
            EditoraModel editoraModel = editoraService.excluirEditora(id);
            response.setData(editoraModel.toGetDto());
            response.setMessage("Sucesso ao excluir editora");
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setData(null);
            response.setMessage("Erro ao excluir editora: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }


}
