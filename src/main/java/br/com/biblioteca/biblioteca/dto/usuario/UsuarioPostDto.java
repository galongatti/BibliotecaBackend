package br.com.biblioteca.biblioteca.dto.usuario;

import br.com.biblioteca.biblioteca.models.UsuarioModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UsuarioPostDto {

    private String nome;

    private String email;

    private String telefone;

    public UsuarioModel toModel() {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(this.nome);
        usuarioModel.setEmail(this.email);
        usuarioModel.setTelefone(this.telefone);
        return usuarioModel;
    }



}
