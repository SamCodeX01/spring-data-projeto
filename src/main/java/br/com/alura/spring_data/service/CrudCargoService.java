package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCargoService {
    Scanner scanner = new Scanner(System.in);
//    private boolean system = true;

//    @Autowired
//    private CargoRepository cargoRepository;

    private final CargoRepository cargoRepository;

    //CONSTRUTOR
    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void exibirMenuCargo() {
        while (true) {
            System.out.print("""
                    ═════════════════════════════
                    MENU FUNCIONÁRIOS
                    ═════════════════════════════
                    
                    Qual ação deseja executar?
                    
                    0 - Sair
                    1 - Salvar Cargo
                    2 - 📝Atualizar Cargo
                    3 - Visualizar Cargo
                    4 - Deletar Cargo
                    
                    Escolha: """);

            int op = scanner.nextInt();

            switch (op){
                case 1 -> inicialCargo(scanner);
                case 3 -> visualizarCargo(scanner);
                case 4 -> deleteCargo(scanner);
            }

        }
    }

    public void inicialCargo(Scanner scanner){
        System.out.print("Digite a Descrição do Cargo: ");
        String descricao = scanner.next(); //Usuario digita

        Cargo cargo = new Cargo(); // Cria um objeto

        cargo.setDescricao(descricao); //seta a descricao o que o usuario digitou no objeto cargo

        cargoRepository.save(cargo);

        System.out.println("Descrição Salva com Sucesso!");

    }

    public void atualizarCargo(Scanner scanner){
        System.out.print("Digite ID");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner




        Optional<Cargo> optional = cargoRepository.findById(id);

        if(optional.isPresent()){
            Cargo cargo =optional.get(); // Pega o cargo existente do banco

            System.out.print("Digite a nova descrição: ");
            String novaDesc = scanner.nextLine();

            cargo.setDescricao(novaDesc); // Atualiza a descrição
            System.out.println("Cargo atualizado com sucesso!");
        } else {
            System.out.println("Cargo com ID " + id + " não encontrado!");

        }
    }

    public void visualizarCargo(Scanner scanner){
        System.out.print("Digite o ID do Cargo a ser visulizado: ");
        int id = scanner.nextInt();

        Optional<Cargo> optional = cargoRepository.findById(id);

        /*
        "Optional contem a classe Cargo e é chamado de optional, recebe o que o repositório encontrar
        através do findById quando busca pelo ID, guardando o resultado (que pode ou não existir) dentro de um Optional
        */

        if(optional.isPresent()){
            Cargo cargo = optional.get();  // Pega o valor dentro do Optional
            System.out.print("Digite uam nova descrição: ");
            String novaDescrição = scanner.nextLine();
            cargo.setDescricao(novaDescrição);
            cargoRepository.save(cargo);
            System.out.println("Cargo atualizado com sucesso!");
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
    }




    public void deleteCargo(Scanner scanner){
        System.out.print("Digite o ID do Cargo a ser deletado: ");
        int id = scanner.nextInt();
        cargoRepository.deleteById(id);
        System.out.println("Cargo: " + id + " deletado");
        //Cargo cargo  = new Cargo():

    }
}

    /*   2 - Atualizar Cargo
    */


