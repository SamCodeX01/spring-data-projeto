package br.com.alura.spring_data.repository;

import br.com.alura.spring_data.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
}
