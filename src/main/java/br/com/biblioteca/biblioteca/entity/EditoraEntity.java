package br.com.biblioteca.biblioteca.entity;


import br.com.biblioteca.biblioteca.models.EditoraModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EDITORA")
@NoArgsConstructor
@Getter
@Setter
public class EditoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EDITORA")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "ENDERECO", length = 255, nullable = true)
    private String endereco;

    @Column(name = "CONTATO", length = 255, nullable = true)
    private String contato;

    @Column(name = "ATIVO", nullable = false)
    private boolean ativo;


    public EditoraModel toModel() {
        EditoraModel editoraModel = new EditoraModel();
        editoraModel.setId(this.id);
        editoraModel.setNome(this.nome);
        editoraModel.setEndereco(this.endereco);
        editoraModel.setContato(this.contato);
        editoraModel.setAtivo(this.ativo);
        return editoraModel;
    }

}
