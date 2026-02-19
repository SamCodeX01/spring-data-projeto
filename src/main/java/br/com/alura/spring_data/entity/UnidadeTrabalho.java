package br.com.alura.spring_data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Unidades")
public class UnidadeTrabalho {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String endereco;
}
