package br.com.alura.spring_data.orm;

import jakarta.persistence.*;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//@GeneratedValue = Valor do campo será gerado automaticamente/IDENTITY = auto-incremento
    private Integer id;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

