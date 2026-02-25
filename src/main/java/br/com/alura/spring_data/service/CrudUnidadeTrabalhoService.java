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
                default -> System.out.println("Digite algo valido!");
            }
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

    public void atualizar(Scanner scanner) {
        System.out.println("Digite o Id da Unidade de Trabalho");
        int id = scanner.nextInt();

        Optional<UnidadeTrabalho> opUnidadeTrabalho = unidadeTrabalhoRepository.findById(id);

        if(opUnidadeTrabalho.isPresent()){
            UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();

            un


            System.out.println("Atualizar Unidade de Trabalho");
            String descricao = scanner.nextLine();

            System.out.println("Atualizar Unidade de Trabalho");
            String endereco = scanner.nextLine();

            unidadeTrabalho.setDescricao(descricao);
            unidadeTrabalho.setEndereco(endereco);

            unidadeTrabalhoRepository.save(unidadeTrabalho);

        }else{}




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