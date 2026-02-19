package br.com.alura.spring_data;

import br.com.alura.spring_data.service.CrudCargoService;
import br.com.alura.spring_data.service.CrudFuncionarioService;
import br.com.alura.spring_data.service.Metodos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication// Varre a aplicação e lê todas as Annotations que tem dentro da aplicação
public class SpringDataApplication implements CommandLineRunner { //SpringDataApplication faz com que o framework do Spring seja inicializado junto a aplicação.

	//Atributos
	private Boolean system = true;
	private final CrudCargoService crudCargoService;//final = variavel inicializada apenas uma vez (geralmente no construtor), não pode ser alterada posteriormente.
	private final CrudFuncionarioService funcionarioService;

	//Construtor
	public SpringDataApplication(CrudCargoService crudCargoService, CrudFuncionarioService funcionarioService){

		this.crudCargoService = crudCargoService;
        this.funcionarioService = funcionarioService;
    }

	//Método principal
	public static void main(String[] args) {

		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("\nQual ação você quer executar: ");
			System.out.print("0 - Sair \n");
			System.out.print("1 - Cargo ");
			System.out.print("\n2 - Funcionário ");
			System.out.print("\n3 - Unidade de Trabalho ");
			System.out.print("\nDigite aqui: ");

			int action = scanner.nextInt();

			switch (action){
				case 1:
//					CrudCargoService crudCargoService = new CrudCargoService();
//					crudCargoService.inicialCargo(scanner);
//					cargoService.inicialCargo();
					crudCargoService.inicialCargo(scanner);
					break;
				case 2:
					funcionarioService.inicialFuncionario(scanner);
					break;
				case 3:
					break;
				default:
					system = false;
					break;
			}
		}

	}

}

/* SpringDataApplication faz com que o framework do Spring seja inicializado junto a aplicação.
É preciso inicializar o framework para que se possa conseguir utilizar suas ferramentas dentro da aplicação.*/