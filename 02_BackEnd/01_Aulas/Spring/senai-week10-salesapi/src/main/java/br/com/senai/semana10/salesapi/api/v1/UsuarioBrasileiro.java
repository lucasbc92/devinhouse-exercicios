package br.com.senai.semana10.salesapi.api.v1;

import br.com.senai.semana10.salesapi.api.UserInterface;

public class UsuarioBrasileiro implements UserInterface {

    private String nome;
    private String dataDeNascimento;
    private String login;
    private String senha;

    public UsuarioBrasileiro(String nome, String dataDeNascimento, String login, String senha) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}