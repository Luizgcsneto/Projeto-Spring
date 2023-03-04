package br.com.flexpagprojetobackendspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.flexpagprojetobackendspring.dtos.ProjetoDto;
import br.com.flexpagprojetobackendspring.dtos.mapper.ProjetoMapper;
import br.com.flexpagprojetobackendspring.exception.RecordNotFoundException;
import br.com.flexpagprojetobackendspring.repository.ProjetoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final ProjetoMapper projetoMapper;

    public ProjetoService(
        ProjetoRepository projetoRepository, 
        ProjetoMapper projetoMapper) {
        this.projetoRepository = projetoRepository;
        this.projetoMapper = projetoMapper;
    }

    public List<ProjetoDto> listProjects() 
    {
        return projetoRepository.findAll()
        .stream().map(projetoMapper::toDto)
        .collect(Collectors.toList());
    }

    public ProjetoDto findById(@PathVariable Long id) 
    {
        return projetoRepository.findById(id).map(projetoMapper::toDto)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public ProjetoDto create(@Valid @NotNull ProjetoDto projeto) 
    {
        return projetoMapper.toDto(projetoRepository
        .save(projetoMapper.toEntity(projeto)));
    }

    public ProjetoDto update(@NotNull @Positive Long id, @Valid @NotNull ProjetoDto projeto) 
    {
        return projetoRepository.findById(id).map(projetoFound -> {
            projetoFound.setName(projeto.name());
            projetoFound.setCategory(projeto.category());
            return projetoMapper.toDto(projetoRepository.save(projetoMapper.toEntity(projeto)));
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable Long id) 
    {
        projetoRepository.delete(projetoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

}
