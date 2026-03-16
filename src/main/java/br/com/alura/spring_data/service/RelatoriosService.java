package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.entity.FuncionarioProjecao;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private boolean system = true;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private FuncionarioRepository funcionarioRepository;
    private FuncionarioProjecao funcionarioProjecao;

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
                    
                    Qual relatório deseja executar?
                   
                    1 - Buscar Funcionário por Nome: 
                    2 - Buscar Funcionário por Nome e Data de Contratação: 
                    3 - Buscar Funcionário por Data de Contratação: 
                    4 - Pesquisa Funcionário Salário: 
                    
                                        
                    Escolha: """);

            int op = scanner.nextInt();

            switch (op) {
                case 1 -> buscaFuncionarioNome(scanner);
                case 2 -> buscaFuncionarioNomeSalarioMaiorData();
                case 3 -> buscaFuncionarioDataContratacao();
                case 4 -> pesquisaFuncionarioSalario();
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

    private void buscaFuncionarioNomeSalarioMaiorData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual nome deseja pesquisar: ");
        String nome = scanner.next();

        System.out.println("Qual data contratação deseja pesquisar: ");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Qual salário deseja pesquisar");
        Double salario = scanner.nextDouble();

        List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        list.forEach(System.out::println);

    }

    private void buscaFuncionarioDataContratacao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual data contratação deseja pesquisar");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
        list.forEach(System.out::println);
    }

    private void pesquisaFuncionarioSalario(){
        List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario(); //FuncionarioProjecao recebe através da @Query no Repositoy o que foi buscado no bando de dados
        list.forEach(f -> System.out.println("Funcionário: id: " + f.getId()
                + " | nome: " + f.getNome() + " | salario: " + f.getSalario()));
        //Acima o forEach lista cada campo buscado no banco de dados que é cada metodo da interface FuncionarioProjecao
    }

}
