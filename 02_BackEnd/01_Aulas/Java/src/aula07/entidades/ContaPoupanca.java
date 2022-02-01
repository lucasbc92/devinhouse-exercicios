package aula07.entidades;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String conta, double saldo){
        super(conta, saldo);
    }

    public String toString(){
        return String.format("CP-%s : $%.2f", this.getConta(), this.getSaldo());
    }
}
