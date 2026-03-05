package br.com.alura.spring_data.repository;

import br.com.alura.spring_data.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {


    // Derived Query: O Spring gera "SELECT * FROM usuario WHERE email = ?"
    Cargo findByEmail(String email);


    // Outro exemplo: Busca por nome contendo e ignorando maiúsculas/minúsculas
    List<Cargo> findByNomeContainingIgnoreCase(String nome);

}
