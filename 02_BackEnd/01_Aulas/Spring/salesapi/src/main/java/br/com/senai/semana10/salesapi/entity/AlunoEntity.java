package br.com.senai.semana10.salesapi.entity;

import jakarta.persistence.*;

@Entity(name = "aluno")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alunoger")
    @SequenceGenerator(name = "alunoger", sequenceName = "aluno_id_aluno_seq", allocationSize = 1)
    private Long idAluno;
    private String nome;
    private String cpf;

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
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
}
