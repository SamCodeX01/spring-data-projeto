package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.UnidadeTrabalho;
import br.com.alura.spring_data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {
    //Atributos
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    //Construtor
    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {//aqui UnidadeTrabalhoRepository é uma classe
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    //Classes e objetos e serem instanciados
    Scanner scanner = new Scanner(System.in);

    //Funções
    public void exibirMenuUnidadeTrabalho() {
        while (true) {
            System.out.print("""
                    ═════════════════════════════
                    MENU UNIDADE DE TRABALHO
                    ═════════════════════════════
                    
                    Qual ação deseja executar?
                    
                    0 - Sair
                    1 - Salvar Unidade de Trabalho
                    2 - Atualizar Unidade de Trabalho
                    3 - Visualizar Unidade de Trabalho
                    4 - Deletar Unidade de Trabalho
                    
                    Escolha: """);

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> salvar(scanner);
                case 2 -> atualizar(scanner);
                case 3 -> visualizar(scanner);
                case 4 -> deletar(scanner);
                default -> System.out.println("\n⚠️ Opção inválida! Digite as opções 1,2,3 ou 4.");
            }
            break;
        }
    }

    public void salvar(Scanner scanner) {
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        System.out.println("Descricao Unidade de Trabalho");
        String descricao = scanner.nextLine();
        System.out.println("Endereço Unidade de Trabalho");
        String endereco = scanner.nextLine();

        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("✅ Descrição e endereço Salvo com Sucesso!");
    }

    public void atualizar(Scanner scanner) {//Aqui o Optional verifica se id buscado está presente no repositório
        System.out.println("Digite o Id da Unidade de Trabalho");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpa o Enter

        Optional<UnidadeTrabalho> opUnidadeTrabalho = unidadeTrabalhoRepository.findById(id);
        //Acima através da Classe (Entidade) UnidadeTrabalho esta buscando o id pelo repositório, o resultado pode ou não existir. Por isso ele vem dentro de um Optional.”

        if(opUnidadeTrabalho.isPresent()){
//            UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();

            UnidadeTrabalho unidadeTrabalho = opUnidadeTrabalho.get();
            //A classe unidadeTrabalho recebe o que está dentro do Optional através do opUnidadeTrabalho buscando o id com o get.

            System.out.print("Atualizar Descrição: ");
            String novaDescricao = scanner.nextLine();

            System.out.print("Atualizar Endereço: ");
            String novoEndereco = scanner.nextLine();

            unidadeTrabalho.setDescricao(novaDescricao);
            unidadeTrabalho.setEndereco(novoEndereco);

            unidadeTrabalhoRepository.save(unidadeTrabalho);

            System.out.println("✅ Unidade de Trabalho Atualizado com Sucesso!");
        }
        else{
            System.out.println("Id: " + id + "não encontrado!");
        }
    }

    public void
    visualizar(Scanner scanner) {
        System.out.println("Nome Unidade de Trabalho");
    }

    public void deletar(Scanner scanner) {
        System.out.print("Id da Unidade a ser Deletada: ");
        int id = scanner.nextInt();
        unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Unidade de Trabalho: " + id + " 🗑️ deletado");
    }
}