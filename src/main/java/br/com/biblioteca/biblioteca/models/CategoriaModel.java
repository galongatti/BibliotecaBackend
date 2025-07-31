package br.com.biblioteca.biblioteca.models;

import br.com.biblioteca.biblioteca.dto.categoria.CategoriaGetDto;
import br.com.biblioteca.biblioteca.entity.CategoriaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class CategoriaModel {

    private Long id;

    private String descricao;

    private boolean ativo;

    public CategoriaEntity toEntity() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(id);
        categoriaEntity.setDescricao(descricao);
        categoriaEntity.setAtivo(ativo);
        return categoriaEntity;
    }

    public CategoriaGetDto toGetDto() {
        CategoriaGetDto categoriaGetDto = new CategoriaGetDto();
        categoriaGetDto.setId(id);
        categoriaGetDto.setDescricao(descricao);
        categoriaGetDto.setAtivo(ativo);
        return categoriaGetDto;
    }

}
