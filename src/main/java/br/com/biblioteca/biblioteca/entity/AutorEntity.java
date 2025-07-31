package br.com.biblioteca.biblioteca.entity;

import br.com.biblioteca.biblioteca.models.AutorModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AUTOR")
@NoArgsConstructor
@Getter
@Setter
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AUTOR")
    private Long id;

    @Column(name = "NOME", length = 255, nullable = false)
    private String nome;

    @Column(name = "ATIVO", nullable = false)
    private boolean ativo = true;

    public AutorModel toModel() {
        AutorModel autorModel = new AutorModel();
        autorModel.setId(this.id);
        autorModel.setNome(this.nome);
        autorModel.setAtivo(this.ativo);
        return autorModel;
    }
}