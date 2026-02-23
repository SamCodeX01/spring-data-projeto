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

    public void exibirMenuFuncionarios() {
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

    public void visualizarCargo(Scanner scanner){
        System.out.print("Digite o ID do Cargo a ser visulizado: ");
        int id = scanner.nextInt();

        Cargo cargo = new Cargo();

        cargo.setId(id);
        cargoRepository.findById(id);

//        Optional <Cargo> cargo = cargoRepository.findById(id);
        System.out.println("Cargo: " + cargo.getDescricao() + " visulizado");
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
         3 - Visualizar Cargo
    */



