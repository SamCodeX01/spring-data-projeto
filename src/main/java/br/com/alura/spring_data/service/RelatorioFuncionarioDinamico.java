package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import br.com.alura.spring_data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Scanner;

public class RelatorioFuncionarioDinamico {
    private final FuncionarioRepository funcionarioRepository;

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        System.out.println("Digite o nome: ");
        String nome = scanner.next();

        //Essa consulta irá retornar uma lista de funcionarios da base de dados(repository) e irá trazer algo que tenha algo parecido entre o inicio e o fim que o usuario digitar, tipo o like %% do sql
        List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
    }
}
