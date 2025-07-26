package br.com.biblioteca.biblioteca.dto.editora;

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
public class EditoraPostDto {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("contato")
    private String contato;

    public EditoraModel toModel() {
        EditoraModel editoraModel = new EditoraModel();
        editoraModel.setNome(this.nome);
        editoraModel.setEndereco(this.endereco);
        editoraModel.setContato(this.contato);
        return editoraModel;
    }
}
