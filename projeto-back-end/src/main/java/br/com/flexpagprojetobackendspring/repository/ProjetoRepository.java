package br.com.flexpagprojetobackendspring.repository;

import br.com.flexpagprojetobackendspring.model.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    
}
