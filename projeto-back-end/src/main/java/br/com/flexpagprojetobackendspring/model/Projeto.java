package br.com.flexpagprojetobackendspring.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
@SQLDelete(sql = "UPDATE Projeto SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Column(length = 100)
    private String name;

    @NotBlank
    @NotNull
    @Column(length = 20)
    private String category;

    @NotBlank
    @NotNull
    @Column(length = 10)
    private String status = "Ativo";
}
