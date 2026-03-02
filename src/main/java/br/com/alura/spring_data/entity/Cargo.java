package br.com.alura.spring_data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//@GeneratedValue = Valor do campo será gerado automaticamente/IDENTITY = auto-incremento
    private Integer id;
    private String descricao;
    @OneToMany(mappedBy = "cargo")//Um cargo pode ter MUITOS(uma List) de funcionários
    private List<Funcionario> funcionario; // É um RELACIONAMENTO com outra entidade (usa @OneToMany),essa lista de funcionários que pertencem a este cargo

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

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

