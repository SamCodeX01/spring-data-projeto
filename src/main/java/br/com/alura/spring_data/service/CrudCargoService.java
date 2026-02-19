package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                    1 - Salvar Funcionário
                    2 - Atualizar Funcionário
                    3 - Visualizar Funcionários
                    4 - Deletar Funcionário
                    
                    Escolha: """);

            int op = scanner.nextInt();

            switch (op){
                //case 1 -> inicialCargo();
                //case 2 -> "📝 Função atualizar (implementar)";
            }

        }
    }

    public void inicialCargo(Scanner scanner){
        System.out.print("Digite a Descrição do Cargo: ");
        String descricao = scanner.next(); //Usuário digita

        Cargo cargo = new Cargo(); // Cria um objeto

        cargo.setDescricao(descricao); //seta a o que o usuario digitou no objeto cargo

        cargoRepository.save(cargo);

        System.out.println("Descrição Salva com Sucesso!");


    }

}
