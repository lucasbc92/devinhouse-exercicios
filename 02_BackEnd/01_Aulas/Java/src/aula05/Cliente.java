package aula05;

public class Cliente {
    private String nome;
    private String sobrenome;
    private int cpf;

    Cliente() {

    }

    Cliente(String nome, String sobrenome, int cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    String getNome() {
        return this.nome;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    String getSobrenome() {
        return this.sobrenome;
    }

    void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    int getCpf() {
        return this.cpf;
    }

    void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
