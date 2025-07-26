package br.com.biblioteca.biblioteca.dto.usuario;

import br.com.biblioteca.biblioteca.models.UsuarioModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UsuarioPutDto {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private boolean ativo;

    public UsuarioModel toModel() {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(this.nome);
        usuarioModel.setEmail(this.email);
        usuarioModel.setTelefone(this.telefone);
        usuarioModel.setId(this.id);
        usuarioModel.setAtivo(this.ativo);
        return usuarioModel;
    }



}
