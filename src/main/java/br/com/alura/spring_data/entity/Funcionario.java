package br.com.alura.spring_data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private double salario;
    private String dataContratacao;
    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;
    @Fetch(FetchMode.SELECT)// Define que os dados serão carregados em consultas SELECT separadas
    @ManyToMany(fetch = FetchType.EAGER) // Relacionamento muitos-para-muitos carregado imediatamente
    @JoinTable(name = "funcionarios_unidades",  // Nome da tabela de junção no banco
            joinColumns = {@JoinColumn(name = "fk_funcionario") }, // Coluna que referencia Funcionario
            inverseJoinColumns = {@JoinColumn(name = "fk_unidade")}) // Coluna que referencia UnidadeTrabalho
    private List<UnidadeTrabalho> unidadeTrabalhos; // Lista de unidades associadas ao funcionário

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }


}

