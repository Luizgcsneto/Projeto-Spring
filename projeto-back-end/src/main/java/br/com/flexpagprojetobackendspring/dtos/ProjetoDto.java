package br.com.flexpagprojetobackendspring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ProjetoDto (
    @JsonProperty("_id") Long id, 
    @NotBlank @NotNull  @Column(length = 100) String name, 
    @NotBlank @NotNull  @Column(length = 20) String category) {
}
