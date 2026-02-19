package br.com.alura.spring_data.service;

import br.com.alura.spring_data.entity.Cargo;
import br.com.alura.spring_data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class Metodos {
    Scanner scanner = new Scanner(System.in);
    private boolean system = true;

    //CargoRepository cargoRepository = new CargoRepository();

    //@Autowired
    private final CargoRepository cargoRepository;

    public Metodos(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }



}
