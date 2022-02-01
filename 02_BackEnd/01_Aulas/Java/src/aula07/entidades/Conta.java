package aula07.entidades;

public class Conta {
    protected String agencia;
    protected String conta;
    protected double saldo;
    protected static int bonus;

    public Conta(String conta, double saldo){
        this.conta = conta;
        this.saldo = saldo;
    }

    public static int bonus(){
        return ++bonus;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    protected boolean temSaldo(double valor) {
        return this.saldo >= valor;
    }

    public boolean transferir(double valor, Conta conta) {
        if(temSaldo(valor)){
            this.saldo -= valor;
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public String getAgencia(){
        return this.agencia;
    }

    public String getConta(){
        return this.conta;
    }

    public double getSaldo(){
        return this.saldo;
    }

    // public String toString(){
    //     return String.format("C%s : $.2f", this.getConta(), this.getSaldo())
    // }
}
