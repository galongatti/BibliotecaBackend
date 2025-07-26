package br.com.biblioteca.biblioteca.service;


import br.com.biblioteca.biblioteca.dto.usuario.UsuarioPostDto;
import br.com.biblioteca.biblioteca.dto.usuario.UsuarioPutDto;
import br.com.biblioteca.biblioteca.entity.UsuarioEntity;
import br.com.biblioteca.biblioteca.models.UsuarioModel;
import br.com.biblioteca.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;



    public UsuarioModel cadastrarUsuario(UsuarioPostDto usuarioPostDto) throws Exception {

        UsuarioModel usuarioModelPost = usuarioPostDto.toModel();
        usuarioModelPost.setDataCadastro(LocalDate.now());
        usuarioModelPost.setAtivo(true);

        UsuarioEntity usuarioEntity = usuarioRepository.save(usuarioModelPost.toEntity());
        return usuarioEntity.toModel();
    }

    public UsuarioModel buscarUsuarioPorId(Long id) throws Exception {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado com o ID: " + id));

        return usuarioEntity.toModel();
    }

    public List<UsuarioModel> buscarTodosUsuarios() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioEntity::toModel).collect(Collectors.toList());
    }

    public UsuarioModel atualizarUsuario(UsuarioPutDto usuarioPutDto) throws Exception {

        UsuarioModel usuarioModel = usuarioPutDto.toModel();

        UsuarioEntity usuarioEntityExistente = usuarioRepository.findById(usuarioModel.getId())
                .orElseThrow(() -> new Exception("Usuário não encontrado com o ID: " + usuarioModel.getId()));

        usuarioModel.setDataCadastro(usuarioEntityExistente.getDataCadastro());
        UsuarioEntity usuarioEntity = usuarioRepository.save(usuarioModel.toEntity());
        return usuarioEntity.toModel();
    }

    public UsuarioModel excluirUsuario(Long id) throws Exception {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado com o ID: " + id));

        usuarioEntity.setAtivo(false); // Marcar como inativo

        UsuarioEntity usuarioExcluido = usuarioRepository.save(usuarioEntity);
        return usuarioExcluido.toModel();
    }
}
