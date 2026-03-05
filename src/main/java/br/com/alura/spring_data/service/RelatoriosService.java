package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private boolean system = true;
    private FuncionarioRepository funcionarioRepository;

    RelatoriosService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    ═════════════════════════════
                    MENU 
                    ═════════════════════════════
                    
                    Qual ação deseja executar?
                   
                    1 - Buscar Funcionário por nome: 
                    
                    
                    Escolha: """);

            int op = scanner.nextInt();

            switch (op) {
                case 1 -> buscaFuncionarioNome(scanner);

                default -> System.out.println("\n⚠️ Opção inválida!");
            }
            //break;
        }

    }

    void buscaFuncionarioNome(Scanner scanner){
        System.out.print("Qual o nome deseja pesquisar: ");
        String nome = scanner.next();

        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        list.forEach(System.out::println);
    }

}
