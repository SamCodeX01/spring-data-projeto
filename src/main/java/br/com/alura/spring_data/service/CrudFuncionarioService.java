package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

    Scanner scanner = new Scanner(System.in);

    //Funções
    public void exibirMenuFuncionario(Scanner scanner) {
        while (true) {
           //Metodos.exibirMenuFuncionarios();

            System.out.print("""
                    ═════════════════════════════
                    MENU FUNCIONÁRIOS
                    ═════════════════════════════
                    
                    Qual ação deseja executar?
                    
                    1 - Salvar Funcionários
                    2 - Atualizar Funcionários
                    3 - Visualizar Funcionários
                    4 - Listar Todas Unidades de Trabalho (fazer ainda)
                    5 - Deletar Funcionários
                    
                    Escolha: """);

            int op = scanner.nextInt();

            switch (op) {
                case 1 -> salvar();
                case 2 -> atualizar();
                case 3 -> visualizar();
                case 5 -> deletar();
                default -> System.out.println("\n⚠️ Opção inválida! Digite as opções 1,2,3 ou 4.");
            }
                    break;
            }
        }

        public void salvar(){
            System.out.print("Nome do Funcionário: ");
            String nome = scanner.nextLine();
            System.out.print("CPF do Funcionário: ");
            String cpf = scanner.nextLine();
            System.out.print("Salário do Funcionário:: ");
            double salario = scanner.nextDouble();
            System.out.print("Data da Contratação: ");
            String dataContratacao = scanner.nextLine();

            Funcionario funcionario = new Funcionario();

            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setSalario(salario);
            funcionario.setDataContratacao(dataContratacao);

            funcionarioRepository.save(funcionario);
            System.out.println("Dados do Funcionário salvo com sucesso!");
        }

    public void atualizar(){//Aqui o Optional verifica se id buscado está presente no repositório
            System.out.print("Id do Funcionário a ser atualizado: ");
            int id = scanner.nextInt();
            scanner.nextLine(); //limpar o buffer

        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id); //optionalFuncionario recece ou não busca pelo id pelo repositorio funcionarioRepository

            if(optionalFuncionario.isPresent()){
                Funcionario funcionario = optionalFuncionario.get();

                System.out.print("Nome do Funcionário: ");
                String novoNome = scanner.next();
                System.out.print("CPF do Funcionário: ");
                String novoCpf = scanner.nextLine();
                System.out.print("Salário do Funcionário:: ");
                double novoSalario = scanner.nextDouble();
                System.out.print("Data da Contratação: ");
                String novaDataContratacao = scanner.next();

                funcionario.setNome(novoNome);
                funcionario.setCpf(novoCpf);
                funcionario.setSalario(novoSalario);
                funcionario.setDataContratacao(novaDataContratacao);

                funcionarioRepository.save(funcionario); // Aqui esta persistindo essa mudança no banco de dados.


                System.out.println("✅ Funcionário Atualizado com Sucesso!");

            }else{
                System.out.println("Funcionário com ID " + id + " não encontrado!");

            }

       }

    public void visualizar(){//Esse metodo Visualiza UM cargo específico (com tratamento de ausência)
//        System.out.print("Digite o ID do Funcionário a ser visualizado: ");
//            int id = scanner.nextInt();
//
//        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
//
//        if(optionalFuncionario.isPresent()){//se o id está presente dentro de optionalFuncionario
//            Funcionario funcionario = optionalFuncionario.get(); //objeto funcionario recebe o id que esta em optionalFuncionario
//
//            System.out.println("Id: " + funcionario.getId());
//            System.out.println("Nome: " + funcionario.getNome());
//            System.out.println("CPF: " + funcionario.getCpf());
//            System.out.println("Salário: " + funcionario.getSalario());
//            System.out.println("Data da Contratação: " + funcionario.getDataContratacao());
//        }else{
//            System.out.println("Funcionário com ID " + id + " não encontrado!");
//        }

        Iterable<Funcionario>funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
       }

    public void deletar(){
        Funcionario funcionario = new Funcionario();
            System.out.print("Digite o ID que sera deletado: ");
            int id = scanner.nextInt();

            funcionarioRepository.deleteById(id);

            System.out.println("Funcionario_id: " + id + " " + funcionario.getNome() + "🗑️deletados");
        }
        //private void visualizar(){}
        //private void deletar(){}
};

