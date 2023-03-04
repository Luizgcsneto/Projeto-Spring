package br.com.flexpagprojetobackendspring.dtos;

import br.com.flexpagprojetobackendspring.model.Projeto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDto {
    
    @NotBlank(message = "Nome não pode estar vazio")
    @NotNull
    @Column(length = 100)
    private String name;

    @NotBlank(message = "Categoria não pode estar vazio")
    @NotNull
    @Column(length = 20)
    private String category;

    public Projeto build(){
        Projeto projeto = new Projeto()
        .setName(this.name)
        .setCategory(this.category);

        return projeto;
    }
}
