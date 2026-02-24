package br.com.alura.spring_data.service;

import br.com.alura.spring_data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

@Service
public class CrudUnidadeTrabalhoService {
    //Atributos
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    //Construtor
    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {//aqui UnidadeTrabalhoRepository é uma classe
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    //Classes e objetos e serem instanciados


    //Funções
    void exibirUnidadeTrabalho(){}





    /*

    private int id;
    private String descricao;
    private String endereco;

    */















}


