package br.com.biblioteca.biblioteca.models;

import br.com.biblioteca.biblioteca.dto.editora.EditoraGetDto;
import br.com.biblioteca.biblioteca.dto.usuario.UsuarioGetDto;
import br.com.biblioteca.biblioteca.entity.EditoraEntity;
import br.com.biblioteca.biblioteca.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EditoraModel {

    private Long id;

    private String nome;

    private String endereco;

    private String contato;

    private boolean ativo;

    public EditoraEntity toEntity() {
        EditoraEntity editoraEntity = new EditoraEntity();
        editoraEntity.setId(id);
        editoraEntity.setNome(nome);
        editoraEntity.setEndereco(endereco);
        editoraEntity.setContato(contato);
        editoraEntity.setAtivo(ativo);

        return editoraEntity;
    }

    public EditoraGetDto toGetDto() {
        return new EditoraGetDto(id, nome, endereco, contato, ativo);
    }
}

