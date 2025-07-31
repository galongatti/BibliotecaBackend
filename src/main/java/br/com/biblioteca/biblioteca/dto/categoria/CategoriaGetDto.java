package br.com.biblioteca.biblioteca.dto.categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaGetDto {

    private Long id;

    private String descricao;

    private boolean ativo;
}
