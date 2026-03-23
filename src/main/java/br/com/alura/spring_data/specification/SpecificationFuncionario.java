package br.com.alura.spring_data.specification;

import br.com.alura.spring_data.entity.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationFuncionario{

    // Cria uma specification que filtra por nome
    public static Specification <Funcionario> nome(String nome){
        // Devolve uma condição de busca
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Funcionario>cpf(String cpf){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<Funcionario>salario(Double salario){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("salario"), salario);
    }

    public static Specification<Funcionario>dataContratacao(LocalDate dataContratacao){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("dataContratacao"), dataContratacao);
    }

}
/*
As palavras reservadas:

🔹 root → Representa a tabela "Funcionario". É como se você apontasse para a tabela e dissesse "é dessa tabela que vou buscar os dados"

🔹 query → Representa a consulta completa. É o objeto que vai montar o SELECT inteiro (raramente usado diretamente)

🔹 criteriaBuilder → É o "construtor" que cria as condições. É ele que faz as comparações: like, equals, greaterThan, etc.
*/