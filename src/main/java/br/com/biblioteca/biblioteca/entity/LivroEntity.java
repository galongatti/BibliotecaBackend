package br.com.biblioteca.biblioteca.entity;

import br.com.biblioteca.biblioteca.models.LivroModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LIVRO")
@NoArgsConstructor
@Getter
@Setter
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIVRO")
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "ANO_PUBLICACAO", length = 4)
    private String anoPublicacao;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "ATIVO")
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "ID_EDITORA", referencedColumnName = "ID_EDITORA")
    private EditoraEntity editora;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    private CategoriaEntity categoria;


    public LivroModel toModel() {
        LivroModel livroModel = new LivroModel();
        livroModel.setId(this.id);
        livroModel.setTitulo(this.titulo);
        livroModel.setAnoPublicacao(this.anoPublicacao);
        livroModel.setIsbn(this.isbn);
        livroModel.setAtivo(this.ativo);

        if (this.editora != null) {
            livroModel.setEditora(this.editora.toModel());
        }

        if (this.categoria != null) {
            livroModel.setCategoria(this.categoria.toModel());
        }

        return livroModel;
    }
}