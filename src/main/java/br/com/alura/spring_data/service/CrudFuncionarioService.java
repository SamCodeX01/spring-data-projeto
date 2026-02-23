package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudFuncionarioService {
    Scanner scanner = new Scanner(System.in);
    private Boolean system = true;


    private final FuncionarioRepository funcionarioRepository;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    public void inicialFuncionario(Scanner scanner) {
        while (true) {
           // Metodos.exibirMenuFuncionarios();

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
            funcionario.setNome(nome);

            funcionarioRepository.save(funcionario);

        }
        //private void visualizar(){}
        //private void deletar(){}

};
