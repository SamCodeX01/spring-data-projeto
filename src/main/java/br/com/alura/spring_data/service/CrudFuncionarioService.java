package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudFuncionarioService {
    Scanner scanner = new Scanner(System.in);
    private Boolean system = true;
    private final FuncionarioRepository funcionarioRepository;

    public CrudFuncionarioService(FuncionarioRepository repositorio) {
        this.funcionarioRepository = repositorio;
    }

    public void inicialFuncionario(Scanner scanner) {
        while (true) {
            exibirMenu();

            int op = scanner.nextInt();

            String acao = switch (op) {
                case 0 -> {
                    yield "👋 Saindo do menu funcionários...";
                }
                case 1 ->  {
                    salvar();
                    yield "✅ Funcionário salvo com sucesso!";
                }
                case 2 -> "📝 Função atualizar (implementar)";
                case 3 -> "📋 Função visualizar (implementar)";
                case 4 -> "🗑️ Função deletar (implementar)";
                default -> "⚠️ Opção inválida! Digite 0-4";
            };

            System.out.println(acao); //mostra a ação escolhida

            if (op == 0) {
                break;//sai do loop
            }

        }
    };
        private void exibirMenu(){
            System.out.println("""
                ═════════════════════════════
                MENU FUNCIONÁRIOS
                ═════════════════════════════
                
                Qual ação deseja executar?
                
                0 - Sair
                1 - Salvar funcionário
                2 - Atualizar funcionário
                3 - Visualizar funcionários
                4 - Deletar funcionário
                
                Escolha: """);
        };

        private void salvar(){
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

        private void atualizar(){
            System.out.print("Nome do Funcionário: ");
            String nome = scanner.next();
            System.out.print("CPF do Funcionário: ");
            int cpf = scanner.nextInt();
            System.out.print("Salário do Funcionário:: ");
            double salario = scanner.nextDouble();
            System.out.print("Data da Contratação: ");
            String dataContratacao = scanner.next();

            Funcionario funcionario = new Funcionario();


        }
        //private void visualizar(){}
        //private void deletar(){}

};
