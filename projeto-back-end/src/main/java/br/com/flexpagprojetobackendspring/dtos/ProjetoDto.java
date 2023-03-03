package br.com.flexpagprojetobackendspring.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProjetoDto {
    
    @NotBlank(message = "Nome não pode estar vazio")
    @NotNull
    @Column(length = 100)
    private String name;

    @NotBlank(message = "Categoria não pode estar vazio")
    @NotNull
    @Column(length = 20)
    private String category;
}
