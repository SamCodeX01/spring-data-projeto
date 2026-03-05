package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCargoService {
    //Atributos
    private final CargoRepository cargoRepository;

    //CONSTRUTOR
    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    Scanner scanner = new Scanner(System.in);

    //Funções
    public void exibirMenuCargo() {
        while (true) {
            System.out.print("""
                    ═════════════════════════════
                    MENU CARGO
                    ═════════════════════════════
                    
                    Qual ação deseja executar?
                   
                    1 - Salvar Cargo
                    2 - Atualizar Cargo
                    3 - Visualizar Cargo
                    4 - Listar Todas Unidades de Trabalho (fazer ainda)
                    5 - Deletar Cargo
                    
                    Escolha: """);

            int op = scanner.nextInt();

            switch (op) {
                case 1 -> salvarCargo(scanner);
                case 2 -> atualizarCargo(scanner);
                case 3 -> visualizarCargo(scanner);
                case 4 -> deleteCargo(scanner);
                default -> System.out.println("\n⚠️ Opção inválida! Digite as opções 1,2,3 ou 4.");
                }
                break;
            }

    }

    public void salvarCargo(Scanner scanner){
        Cargo cargo = new Cargo(); // Cria um objeto

        System.out.print("Digite a Descrição do Cargo: ");
        String descCargo = scanner.next(); //Usuario digita

        cargo.setDescricao(descCargo); //define o atributo do objeto descricao da classe Cargo através do que o usuario digitou com o scanner descCargo

        cargoRepository.save(cargo); //salva no repositório

        System.out.println("✅ Descrição Salva com Sucesso!");

    }

    public void atualizarCargo(Scanner scanner){
        System.out.print("Digite ID");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        Optional<Cargo> optional = cargoRepository.findById(id);

        if(optional.isPresent()){
            Cargo cargo = optional.get(); // Pega o cargo existente do banco

            System.out.print("Digite a nova descrição: ");
            String novaDescCargo = scanner.nextLine();

            cargo.setDescricao(novaDescCargo); // Atualiza a descrição

            cargoRepository.save(cargo); // Aqui esta persistindo essa mudança no banco de dados.

            System.out.println("✅ Cargo atualizado com sucesso!");
        } else {
            System.out.println("Cargo com ID " + id + " não encontrado!");
        }
    }

    public void visualizarCargo(Scanner scanner){
        System.out.print("Digite o ID do Cargo a ser visualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //Limpa o buffer

        Optional<Cargo> optional = cargoRepository.findById(id);

        /*
        "Optional contem a classe Cargo e é chamado de optional, recebe o que o repositório encontrar
        através do findById quando busca pelo Id, guardando o resultado (que pode ou não existir) dentro do Optional
        */

        if(optional.isPresent()){//Aqui o Optional verifica se id buscado está presente no repositório
            Cargo cargo = optional.get(); // Pega o objeto cargo encontrado através do Id

            // SÓ VISUALIZA - mostra os dados na tela
            System.out.println("\n=== DADOS DO CARGO ===");
            System.out.println("ID: " + cargo.getId());
            System.out.println("Descrição: " + cargo.getDescricao());
        }
        else{
            System.out.println("Cargo com ID " + id + " não encontrado!");
        }

        /*
        Optional é uma classe que serve como um container, indica se um objeto pode ou não estar presente.
        Ao fazer uma busca no banco de dados por ID utlizando o findById, existem duas possibilidades:
        Se o registro existe → retorna o objeto dentro do Optional
        Se o registro NÃO existe → retorna um Optional vazio (não é null!)
        */
//        System.out.println("Cargo: " + cargo.getDescricao() + " visualizado");

//        Iterable<Cargo> cargos = cargoRepository.findAll();
//        cargos.forEach(cargo -> System.out.println(cargo));
    }

    public void deleteCargo(Scanner scanner){
        System.out.print("Digite o ID do Cargo a ser deletado: ");
        int id = scanner.nextInt(); //aqui o usuario digita o id a ser dletado
        cargoRepository.deleteById(id); //Busca o id a ser deletado no repositório cargoRepository
        System.out.println("Cargo: " + id + " 🗑️ deletado");
    }
}
