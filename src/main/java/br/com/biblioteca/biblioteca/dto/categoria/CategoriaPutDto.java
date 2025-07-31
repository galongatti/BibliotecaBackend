package br.com.biblioteca.biblioteca.dto.categoria;

import br.com.biblioteca.biblioteca.models.CategoriaModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaPutDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("descricao")
    private String descricao;

    public CategoriaModel toModel() {
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(this.id);
        categoriaModel.setDescricao(this.descricao);
        return categoriaModel;
    }


}
