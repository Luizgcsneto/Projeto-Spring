package br.com.flexpagprojetobackendspring.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.flexpagprojetobackendspring.model.Projeto;
import br.com.flexpagprojetobackendspring.repository.ProjetoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Validated
@RestController
@RequestMapping("api/project")
@AllArgsConstructor
public class ProjetoController {

    @Autowired
    private final ProjetoRepository projetoRepository;


    @GetMapping
    @ResponseBody
    public List<Projeto> listProjects() {
        return projetoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable @NotNull @Positive Long id) {
        return projetoRepository.findById(id)
        .map(project -> ResponseEntity.ok().body(project))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Projeto> create(@RequestBody @Valid Projeto projeto) {
        Projeto projetoEntity = projetoRepository.save(projeto);
        return new ResponseEntity<Projeto>(projetoEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Projeto> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Projeto projeto) {
        return projetoRepository.findById(id).map(projetoFound ->{
            projetoFound.setName(projeto.getName());
            projetoFound.setCategory(projeto.getCategory());
            Projeto updated = projetoRepository.save(projetoFound);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        return projetoRepository.findById(id).map(projetoFound -> {
            projetoRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
