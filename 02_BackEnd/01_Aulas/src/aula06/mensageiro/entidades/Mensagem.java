package aula06.mensageiro.entidades;

public class Mensagem {
    private Pessoa remetente;
    private String corpo;

    Mensagem(Pessoa remetente, String corpo) {
        this.remetente = remetente;
        this.corpo = corpo;
    }

    public Pessoa getRemetente(){
        return this.remetente;
    }

    public String getCorpo(){
        return this.corpo;
    }

    public String toString(){
        return this.remetente.getNome() + ": " + this.getCorpo();
    }
}
