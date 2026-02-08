package br.com.alura.spring_data;

import br.com.alura.spring_data.orm.Cargo;
import br.com.alura.spring_data.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication// Varre a aplicação e lê todas as Annotations que tem dentro da aplicação
public class SpringDataApplication implements CommandLineRunner { //SpringDataApplication faz com que o framework do Spring seja inicializado junto a aplicação.

	private final CargoRepository repository;//final = variavel inicializada apenas uma vez (geralmente no construtor), não possa ser alterada posteriormente.

	public SpringDataApplication(CargoRepository repository){
		this.repository = repository;
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("DESENVOLVEDOR DE SOFTWARE");

		repository.save(cargo); //Salvando o objeto cargo da classe Cargo no banco de dados
	}
}


/* SpringDataApplication faz com que o framework do Spring seja inicializado junto a aplicação.
É preciso inicializar o framework para que se possa conseguir utilizar suas ferramentas dentro da aplicação.*/