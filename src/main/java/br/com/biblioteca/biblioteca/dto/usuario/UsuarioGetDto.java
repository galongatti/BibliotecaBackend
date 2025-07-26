package br.com.biblioteca.biblioteca.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioGetDto {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private LocalDate dataCadastro;

    private boolean ativo;
}
