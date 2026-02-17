package br.com.alura.spring_data.repository;

import br.com.alura.spring_data.orm.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
