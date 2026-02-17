package br.com.alura.spring_data.repository;

import br.com.alura.spring_data.orm.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeTrabalhoRepository extends JpaRepository<Unidade,Integer> {
}
