package br.com.biblioteca.biblioteca.dto.livro;

import br.com.biblioteca.biblioteca.models.AutorModel;
import br.com.biblioteca.biblioteca.models.CategoriaModel;
import br.com.biblioteca.biblioteca.models.EditoraModel;
import br.com.biblioteca.biblioteca.models.LivroModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class LivroPutDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("anoPublicacao")
    private String anoPublicacao;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("editora")
    private Long codigoEditora;

    @JsonProperty("categoria")
    private Long codigoCategoria;

    public LivroModel toModel() {

        LivroModel livroModel = new LivroModel();
        livroModel.setTitulo(this.titulo);
        livroModel.setAnoPublicacao(this.anoPublicacao);
        livroModel.setIsbn(this.isbn);
        livroModel.setId(this.id);

        EditoraModel editoraModel = new EditoraModel();
        editoraModel.setId(this.codigoEditora);
        livroModel.setEditora(editoraModel);

        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(this.codigoCategoria);
        livroModel.setCategoria(categoriaModel);

        return livroModel;
    }
}
