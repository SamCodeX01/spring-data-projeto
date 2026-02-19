package br.com.alura.spring_data.service;

import br.com.alura.spring_data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

@Service
public class CrudUnidadeTrabalhoService {
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository repositorio) {//aqui UnidadeTrabalhoRepository é uma classe
        this.unidadeTrabalhoRepository = repositorio;
    }
}
