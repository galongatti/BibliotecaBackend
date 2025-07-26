package br.com.biblioteca.biblioteca.models;
import br.com.biblioteca.biblioteca.dto.usuario.UsuarioGetDto;
import br.com.biblioteca.biblioteca.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UsuarioModel {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private LocalDate dataCadastro;

    private boolean ativo;

    public UsuarioEntity toEntity() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(this.id);
        usuarioEntity.setNome(this.nome);
        usuarioEntity.setEmail(this.email);
        usuarioEntity.setTelefone(this.telefone);
        usuarioEntity.setDataCadastro(this.dataCadastro);
        usuarioEntity.setAtivo(this.ativo);
        return usuarioEntity;
    }

    public UsuarioGetDto toGetDto() {
        return new UsuarioGetDto(id, nome, email, telefone, dataCadastro, ativo);
    }
}

