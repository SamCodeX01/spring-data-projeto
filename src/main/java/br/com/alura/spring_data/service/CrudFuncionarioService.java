package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

import static jdk.internal.jrtfs.JrtFileAttributeView.AttrID.size;

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

    public void visualizar(){//Método público que não retorna valor (void) e serve para visualizar funcionários de forma paginada.

        System.out.print("Qual página você deseja visualizar: ");
        Integer page = scanner.nextInt();//Lê entrada do usuário - Captura o número digitado pelo usuário (ex: 0, 1, 2...) e armazena na variável page. Este número indica qual página de resultados será exibida.

        //Pageable pageable = PageRequest.of(page, 5, Sort.unsorted());
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "nome");
        //PageRequest.of() metodo estático que cria uma requisição de página/page: número da página solicitada (começa em 0)/5: quantidade de registros por página/Sort.unsorted(): define que não haverá ordenação específica

        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);//O banco de dados retorna APENAS os registros da página solicitada (não carrega todos)

        System.out.println("Conteúdo da página:");
        funcionarios.forEach(funcionario -> System.out.println(funcionario)); //A expressão funcionario -> System.out.println(funcionario) imprime cada funcionário (chamando seu método toString())

        // System.out.println(funcionarios);
        System.out.println("Página atual " + funcionarios.getNumber()); //getNumber() retorna o número da página atual (começa em 0)
        System.out.println("Total elemento " + funcionarios.getTotalElements());
        System.out.println("Total de páginas: " + funcionarios.getTotalPages());
    }

    public void deletar(){
        Funcionario funcionario = new Funcionario();
            System.out.print("Digite o ID que sera deletado: ");
            int id = scanner.nextInt();

            funcionarioRepository.deleteById(id);

            System.out.println("Funcionario_id: " + id + " " + funcionario.getNome() + "🗑️deletados");
        }
};
