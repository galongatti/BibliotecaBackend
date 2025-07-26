package br.com.biblioteca.biblioteca.dto.editora;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditoraGetDto {

    private Long id;

    private String nome;

    private String endereco;

    private String contato;

    private boolean ativo;
}
