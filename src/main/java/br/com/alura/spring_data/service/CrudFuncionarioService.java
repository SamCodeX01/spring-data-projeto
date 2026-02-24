package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudFuncionarioService {
    //Atributos
    private Boolean system = true;
    private final FuncionarioRepository funcionarioRepository;

    //Construtor
    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    Funcionario funcionario = new Funcionario();
    Scanner scanner = new Scanner(System.in);

    //Funções
    public void exibirFuncionario(Scanner scanner) {
        while (true) {
           //Metodos.exibirMenuFuncionarios();

            System.out.print("""
                    ═════════════════════════════
                    MENU FUNCIONÁRIOS
                    ═════════════════════════════
                    
                    Qual ação deseja executar?
                    
                    0 - Sair
                    1 - Salvar Cargo
                    2 - Atualizar Cargo
                    3 - Visualizar Cargo
                    4 - Deletar Cargo
                    
                    Escolha: """);

            int op = scanner.nextInt();

            switch (op) {
                case 1 -> salvar();
                case 2 -> atualizar();
                case 3 -> visualizar();
                case 4 -> deletar();
                default -> System.out.println("⚠️ Opção inválida! Digite 0-4");               }
            }
        }


        public void salvar(){
            System.out.print("Nome do Funcionário: ");
            String nome = scanner.next();
            System.out.print("CPF do Funcionário: ");
            int cpf = scanner.nextInt();
            System.out.print("Salário do Funcionário:: ");
            double salario = scanner.nextDouble();
            System.out.print("Data da Contratação: ");
            String dataContratacao = scanner.next();

            Funcionario funcionario = new Funcionario();

            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setSalario(salario);
            funcionario.setDataContratacao(dataContratacao);

            funcionarioRepository.save(funcionario);
            System.out.println("Funcionário salvo com sucesso!");
            System.out.println("Dados do Funcionário salvo com sucesso!");
        }

    public void atualizar(){
            System.out.print("Nome do Funcionário: ");
            String nome = scanner.next();
            System.out.print("CPF do Funcionário: ");
            int cpf = scanner.nextInt();
            System.out.print("Salário do Funcionário:: ");
            double salario = scanner.nextDouble();
            System.out.print("Data da Contratação: ");
            String dataContratacao = scanner.next();

            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nome);

            funcionarioRepository.save(funcionario);
       }

    public void visualizar(){
           System.out.print("Digite o ID do Funcionário a ser visualizado: ");
       }

    public void deletar(){
            System.out.print("Digite o ID que sera deletado: ");
            int id = scanner.nextInt();
            funcionarioRepository.deleteById(id);

            funcionario.getNome();

            System.out.println("Funcionario_id: " + id + " " + funcionario.getNome() + "🗑️deletados");

        }
        //private void visualizar(){}
        //private void deletar(){}

};
