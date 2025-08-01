package br.com.biblioteca.biblioteca.dto.livro;

import br.com.biblioteca.biblioteca.dto.categoria.CategoriaGetDto;
import br.com.biblioteca.biblioteca.dto.editora.EditoraGetDto;
import br.com.biblioteca.biblioteca.models.CategoriaModel;
import br.com.biblioteca.biblioteca.models.EditoraModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroGetDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("anoPublicacao")
    private String anoPublicacao;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("ativo")
    private boolean ativo;

    @JsonProperty("editora")
    private EditoraGetDto editora;

    @JsonProperty("categoria")
    private CategoriaGetDto categoria;
}
