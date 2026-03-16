package br.com.alura.spring_data.specification;

import br.com.alura.spring_data.entity.Funcionario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFuncionario{

    public static Specification <Funcionario> nome(String nome){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

}
