package br.com.alura.spring_data;

import br.com.alura.spring_data.orm.Cargo;
import br.com.alura.spring_data.repository.CargoRepository;
import br.com.alura.spring_data.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication// Varre a aplicação e lê todas as Annotations que tem dentro da aplicação
public class SpringDataApplication implements CommandLineRunner { //SpringDataApplication faz com que o framework do Spring seja inicializado junto a aplicação.

	private final CrudCargoService cargoService;//final = variavel inicializada apenas uma vez (geralmente no construtor), não pode ser alterada posteriormente.
	private Boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService){

		this.cargoService = cargoService;
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("Qual ação você quer executar: ");
			System.out.print("0 - Sair: \n");
			System.out.print("1 - Cargo: ");

			int action = scanner.nextInt();

			if(action == 1){
				cargoService.inicial(scanner);
			}else {
				system = false;
			}
		}

	}
}


/* SpringDataApplication faz com que o framework do Spring seja inicializado junto a aplicação.
É preciso inicializar o framework para que se possa conseguir utilizar suas ferramentas dentro da aplicação.*/