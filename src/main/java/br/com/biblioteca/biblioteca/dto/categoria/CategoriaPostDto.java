package br.com.biblioteca.biblioteca.dto.categoria;

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
public class CategoriaPostDto {

    @JsonProperty("descricao")
    private String descricao;

    public CategoriaModel toModel() {
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setDescricao(this.descricao);
        return categoriaModel;
    }
}
