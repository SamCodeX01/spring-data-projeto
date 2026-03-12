package br.com.alura.spring_data.repository;

import br.com.alura.spring_data.entity.Funcionario;
import br.com.alura.spring_data.entity.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);

        @Query("select f from Funcionario f where f.nome = :nome and f.salario = >= salario and f.dataContratacao = :data ")
        List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double Salario, LocalDate data);

        @Query("select * from funcionarios where data_contratacao", nativeQuery = true)
        List<Funcionario> findDataContratacaoMaior(LocalDate data);


        @Query(value = "select id, nome, salario from funcionarios", nativeQuery = true)
        List<FuncionarioProjecao> findFuncionariosSalario();

    }


    /*

JPQL (Java Persistence Query Language) = É uma linguagem de consulta orientada a objetos,
similar ao SQL, mas trabalha com as entidades Java ao invés de tabelas do banco.
*/

