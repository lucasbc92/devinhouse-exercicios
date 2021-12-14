package aula07.entidades;

public class ContaCorrente extends Conta {
    public ContaCorrente(String conta, double saldo){
        super(conta, saldo);
    }

    public String toString(){
        return String.format("CC-%s : $%.2f", this.getConta(), this.getSaldo());
    }

    public void sacar(int valor){
        if(temSaldo(valor)){
            this.saldo -= valor;
        }
    }
}
