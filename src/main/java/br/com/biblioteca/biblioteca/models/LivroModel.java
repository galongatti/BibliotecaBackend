package br.com.biblioteca.biblioteca.models;

import br.com.biblioteca.biblioteca.dto.livro.LivroGetDto;
import br.com.biblioteca.biblioteca.entity.LivroEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class LivroModel {

    private Long id;

    private String titulo;

    private String anoPublicacao;

    private String isbn;

    private EditoraModel editora;

    private CategoriaModel categoria;

    private boolean ativo;


    public LivroEntity toEntity() {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setId(this.id);
        livroEntity.setTitulo(this.titulo);
        livroEntity.setAnoPublicacao(this.anoPublicacao);
        livroEntity.setIsbn(this.isbn);
        livroEntity.setAtivo(this.ativo);
        livroEntity.setEditora(this.editora.toEntity());
        livroEntity.setCategoria(this.categoria.toEntity());
        return livroEntity;
    }

    public LivroGetDto toGetDto() {
        LivroGetDto livroGetDto = new LivroGetDto();
        livroGetDto.setId(this.id);
        livroGetDto.setTitulo(this.titulo);
        livroGetDto.setAnoPublicacao(this.anoPublicacao);
        livroGetDto.setIsbn(this.isbn);
        livroGetDto.setEditora(this.editora.toGetDto());
        livroGetDto.setCategoria(this.categoria.toGetDto());
        livroGetDto.setAtivo(this.ativo);
        return livroGetDto;
    }

}
