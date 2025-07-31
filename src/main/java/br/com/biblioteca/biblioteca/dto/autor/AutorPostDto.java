package br.com.biblioteca.biblioteca.dto.autor;

import br.com.biblioteca.biblioteca.models.AutorModel;
import br.com.biblioteca.biblioteca.models.UsuarioModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AutorPostDto {

    @JsonProperty("nome")
    private String nome;

    public AutorModel toModel() {
        AutorModel autorModel = new AutorModel();
        autorModel.setNome(this.nome);
        return autorModel;
    }

}
