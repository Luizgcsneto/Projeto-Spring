package br.com.flexpagprojetobackendspring.dtos.mapper;

import org.springframework.stereotype.Component;

import br.com.flexpagprojetobackendspring.dtos.ProjetoDto;
import br.com.flexpagprojetobackendspring.model.Projeto;

@Component
public class ProjetoMapper {

    public ProjetoDto toDto(Projeto projeto) 
    {

        if (projeto == null) 
        {
            return null;
        }

        return new ProjetoDto(
                projeto.getId(),
                projeto.getName(),
                projeto.getCategory());
    }

    public Projeto toEntity(ProjetoDto projetoDto) 
    {

        if (projetoDto == null) {
            return null;
        }

        Projeto projeto = new Projeto();
        if (projetoDto.id() != null) {
            projeto.setId(projetoDto.id());
        }

        projeto.setName(projetoDto.name());
        projeto.setCategory(projetoDto.category());
        projeto.setStatus("Ativo");

        return projeto;
    }

}
