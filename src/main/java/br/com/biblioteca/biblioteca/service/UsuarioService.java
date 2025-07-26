package br.com.biblioteca.biblioteca.service;

import br.com.biblioteca.biblioteca.dto.usuario.UsuarioPostDto;
import br.com.biblioteca.biblioteca.dto.usuario.UsuarioPutDto;
import br.com.biblioteca.biblioteca.models.UsuarioModel;

import java.util.List;

public interface UsuarioService {
    UsuarioModel cadastrarUsuario(UsuarioPostDto usuarioPostDto) throws Exception;
    UsuarioModel buscarUsuarioPorId(Long id) throws Exception;
    List<UsuarioModel> buscarTodosUsuarios();
    UsuarioModel atualizarUsuario(UsuarioPutDto usuarioPutDto) throws Exception;
    UsuarioModel excluirUsuario(Long id) throws Exception;
}

