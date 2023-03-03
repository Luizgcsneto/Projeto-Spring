package br.com.flexpagprojetobackendspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.flexpagprojetobackendspring.model.Projeto;
import br.com.flexpagprojetobackendspring.repository.ProjetoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@Component
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listProjects()
    {
        return projetoRepository.findAll();
    }

    public ResponseEntity<Projeto> findById(@PathVariable @Positive Long id)
    {
        return projetoRepository.findById(id)
        .map(project -> ResponseEntity.ok().body(project))
        .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Projeto> create(@Valid @RequestBody Projeto projeto)
    {
        Projeto projetoEntity = projetoRepository.save(projeto);
        return new ResponseEntity<Projeto>(projetoEntity, HttpStatus.CREATED);
    }

    public ResponseEntity<Projeto> update(@Valid @PathVariable Long id, @RequestBody Projeto projeto)
    {
        return projetoRepository.findById(id).map(projetoFound ->{
            projetoFound.setName(projeto.getName());
            projetoFound.setCategory(projeto.getCategory());
            Projeto updated = projetoRepository.save(projetoFound);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> delete(@PathVariable @Positive Long id){
        return projetoRepository.findById(id).map(projetoFound -> {
            projetoRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }


    
}
