package br.com.alura.spring_data.repository;

import br.com.alura.spring_data.entity.UnidadeTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends JpaRepository<UnidadeTrabalho,Integer> {
}
