package br.com.biblioteca.biblioteca.entity;


import br.com.biblioteca.biblioteca.models.CategoriaModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CATEGORIA")
@NoArgsConstructor
@Getter
@Setter
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, length = 255)
    private String descricao;

    @Column(name = "ATIVO", nullable = false)
    private boolean ativo;

    public CategoriaModel toModel() {
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(this.id);
        categoriaModel.setDescricao(this.descricao);
        categoriaModel.setAtivo(this.ativo);
        return categoriaModel;
    }
}
