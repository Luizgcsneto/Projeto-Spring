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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.flexpagprojetobackendspring.model.Projeto;
import br.com.flexpagprojetobackendspring.repository.ProjetoRepository;
import br.com.flexpagprojetobackendspring.service.ProjetoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("api/project")
@AllArgsConstructor
public class ProjetoController {

    @Autowired
    private final ProjetoService projetoService;

    private ModelMapper modelMapper;

    @GetMapping
    @ResponseBody
    public List<Projeto> listProjects() 
    {
        return projetoService.listProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable @Positive Long id) 
    {
        return projetoService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Projeto> create(@Valid @RequestBody Projeto projeto) 
    {
        return projetoService.create(projeto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Projeto> update(@Valid @PathVariable Long id, @RequestBody Projeto projeto)
    {
        return projetoService.update(id, projeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive Long id) 
    {
     return projetoService.delete(id);
    }

}
