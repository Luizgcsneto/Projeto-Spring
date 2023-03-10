package br.com.flexpagprojetobackendspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.flexpagprojetobackendspring.dtos.ProjetoDto;
import br.com.flexpagprojetobackendspring.service.ProjetoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("api/project")
@AllArgsConstructor
public class ProjetoController {

    @Autowired
    private final ProjetoService projetoService;

    @GetMapping
    @ResponseBody
    public List<ProjetoDto> listProjects() {
        return projetoService.listProjects();
    }

    @GetMapping("/{id}")
    public ProjetoDto findById(@PathVariable @NotNull @Positive Long id) 
    {
        return projetoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjetoDto create(@RequestBody @Valid ProjetoDto projeto) 
    {
        return  projetoService.create(projeto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ProjetoDto update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull ProjetoDto projeto) {
        return projetoService.update(id, projeto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) 
    {
        projetoService.delete(id);
    }
}
