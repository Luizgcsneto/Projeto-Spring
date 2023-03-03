package br.com.flexpagprojetobackendspring.repository;

import org.springframework.stereotype.Repository;

import br.com.flexpagprojetobackendspring.model.Projeto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> 
{
    
}
