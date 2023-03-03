package br.com.flexpagprojetobackendspring.model;
import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank(message = "Nome não pode estar vazio")
    @NotNull
  //  @Length(min = 5, max = 100)
   // @Size(min = 5, max = 100)
   @Column(length = 100)
    private String name;

    @NotBlank(message = "Categoria não pode estar vazio")
    @NotNull
   // @Length(max = 12)
    //@Size(max = 12)
    @Column(length = 20)
    private String category;
}
