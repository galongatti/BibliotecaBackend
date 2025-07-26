package br.com.biblioteca.biblioteca.controller;


import br.com.biblioteca.biblioteca.dto.usuario.UsuarioGetDto;
import br.com.biblioteca.biblioteca.dto.usuario.UsuarioPostDto;
import br.com.biblioteca.biblioteca.dto.usuario.UsuarioPutDto;
import br.com.biblioteca.biblioteca.models.UsuarioModel;
import br.com.biblioteca.biblioteca.response.Response;
import br.com.biblioteca.biblioteca.service.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImp usuarioServiceImp;

    @PostMapping("/")
    public ResponseEntity<Response<UsuarioGetDto>> cadastrarUsuario(@RequestBody UsuarioPostDto usuarioPostDto) {

        Response<UsuarioGetDto> response = new Response<>();
        try {

            UsuarioModel usuarioModel = usuarioServiceImp.cadastrarUsuario(usuarioPostDto);

            response.setData(usuarioModel.toGetDto());
            response.setMessage("Sucesso ao cadastrar usuário");
            response.setSuccess(true);
            return  ResponseEntity.ok(response);

        } catch (Exception ex){

            response.setData(null);
            response.setMessage("Erro ao cadastrar usuário: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<UsuarioGetDto>> buscarUsuarioPorId(@PathVariable Long id) {

        Response<UsuarioGetDto> response = new Response<>();
        try {

            UsuarioModel usuarioModel = usuarioServiceImp.buscarUsuarioPorId(id);

            response.setData(usuarioModel.toGetDto());
            response.setMessage("Sucesso ao buscar usuário");
            response.setSuccess(true);
            return ResponseEntity.ok(response);

        } catch (Exception ex){

            response.setData(null);
            response.setMessage("Erro ao buscar usuário: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<UsuarioGetDto>>> buscarTodosUsuarios() {

        Response<List<UsuarioGetDto>> response = new Response<>();
        try {

            List<UsuarioModel> usuarioModelList = usuarioServiceImp.buscarTodosUsuarios();
            List<UsuarioGetDto> usuarioGetDtos = usuarioModelList.stream().map(UsuarioModel::toGetDto).toList();

            response.setData(usuarioGetDtos);
            response.setMessage("Sucesso ao buscar todos os usuários");
            response.setSuccess(true);
            return ResponseEntity.ok(response);

        } catch (Exception ex){
            response.setData(null);
            response.setMessage("Erro ao buscar usuários: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping
    public ResponseEntity<Response<UsuarioGetDto>> atualizarUsuario(@RequestBody UsuarioPutDto usuarioPutDto) {

        Response<UsuarioGetDto> response = new Response<>();
        try {

            UsuarioModel usuarioModel = usuarioServiceImp.atualizarUsuario(usuarioPutDto);

            response.setData(usuarioModel.toGetDto());
            response.setMessage("Sucesso ao atualizar usuário");
            response.setSuccess(true);
            return ResponseEntity.ok(response);

        } catch (Exception ex){

            response.setData(null);
            response.setMessage("Erro ao atualizar usuário: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<UsuarioGetDto>> deletarUsuario(@PathVariable Long id) {

        Response<UsuarioGetDto> response = new Response<>();
        try {

            UsuarioModel usuarioModel = usuarioServiceImp.excluirUsuario(id);

            response.setData(usuarioModel.toGetDto());
            response.setMessage("Sucesso ao deletar usuário");
            response.setSuccess(true);
            return ResponseEntity.ok(response);

        } catch (Exception ex){

            response.setData(null);
            response.setMessage("Erro ao deletar usuário: " + ex.getMessage());
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
