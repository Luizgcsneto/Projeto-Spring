package br.com.flexpagprojetobackendspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.flexpagprojetobackendspring.model.Projeto;
import br.com.flexpagprojetobackendspring.repository.ProjetoRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(ProjetoRepository projetoRepository) 
	{
		return args -> {
			projetoRepository.deleteAll();
			Projeto projeto = new Projeto();
			projeto.setName("Java");
			projeto.setCategory("Back-end");
			projetoRepository.save(projeto);
		};
	}

}
