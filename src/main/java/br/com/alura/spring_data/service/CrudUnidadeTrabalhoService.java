package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.UnidadeTrabalho;
import br.com.alura.spring_data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

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
    UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();

    //Funções
    public void exibirMenuUnidadeTrabalho(){
        while(true){
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

                    switch (op){
                        case 1 -> salvar(scanner);
                        default -> System.out.println("Digite algo valido!");
                    }
        }
    }

    public void salvar(Scanner scanner){
        System.out.println("Descricao Unidade de Trabalho");
        String descricao = scanner.nextLine();
        System.out.println("Endereço Unidade de Trabalho");
        String endereco = scanner.nextLine();

        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("✅ Descrição e endereço Salvo com Sucesso!");
    }
    public void atualizar(){System.out.println("Nome Unidade de Trabalho");}
    public void visualizar(){System.out.println("Nome Unidade de Trabalho");}
    public void  deletar(){System.out.println("Nome Unidade de Trabalho");}




    /*

    private int id;
    private String descricao;
    private String endereco;

    */















}


