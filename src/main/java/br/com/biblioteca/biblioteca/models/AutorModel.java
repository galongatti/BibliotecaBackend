package br.com.biblioteca.biblioteca.models;


import br.com.biblioteca.biblioteca.dto.autor.AutorGetDto;
import br.com.biblioteca.biblioteca.entity.AutorEntity;
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
@AllArgsConstructor
@NoArgsConstructor
public class AutorModel {

    private Long id;

    private String nome;

    private boolean ativo;

    public AutorEntity toEntity() {
        AutorEntity autorEntity = new AutorEntity();
        autorEntity.setId(this.id);
        autorEntity.setNome(this.nome);
        autorEntity.setAtivo(this.ativo);
        return autorEntity;
    }

    public AutorGetDto toGetDto() {
        AutorGetDto autorGetDto = new AutorGetDto();
        autorGetDto.setId(this.id);
        autorGetDto.setNome(this.nome);
        autorGetDto.setAtivo(this.ativo);
        return autorGetDto;
    }
}
