package br.com.flexpagprojetobackendspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.flexpagprojetobackendspring.exception.RecordNotFoundException;
import br.com.flexpagprojetobackendspring.model.Projeto;
import br.com.flexpagprojetobackendspring.repository.ProjetoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@Service
public class ProjetoService {

    
    private final ProjetoRepository projetoRepository;

    public ProjetoService (ProjetoRepository projetoRepository)
    {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> listProjects()
    {
        return projetoRepository.findAll();
    }

    public Projeto findById(@PathVariable Long id)
    {
        return projetoRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Projeto create(@Valid Projeto projeto)
    {
        return projetoRepository.save(projeto);
    }

    public Projeto update(@NotNull @Positive Long id, @Valid Projeto projeto)
    {
        return projetoRepository.findById(id).map(projetoFound ->{
            projetoFound.setName(projeto.getName());
            projetoFound.setCategory(projeto.getCategory());
              return projetoRepository.save(projetoFound);
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable Long id)
    {
        projetoRepository.delete(projetoRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
    }

}
