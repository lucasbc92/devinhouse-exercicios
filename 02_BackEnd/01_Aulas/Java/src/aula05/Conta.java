package aula05;

public class Conta {
    private Cliente cliente = new Cliente();
    private double saldo;
    private double limite = 200;
    private static int totalDeContas;

    public Conta() {
        Conta.totalDeContas++;
    }

    public Conta(double saldo) {
        this.saldo = saldo;
        System.out.println("Nova conta criada!");
        Conta.totalDeContas++;
    }

    private Conta(String nome, String sobrenome, int cpf) {
        this.cliente = new Cliente(nome, sobrenome, cpf);        
    }

    public Conta(String nome, String sobrenome, int cpf, double saldo) {
        this(nome, sobrenome, cpf);
        this.saldo = saldo;
        Conta.totalDeContas++;
    }

    private boolean temSaldo(double valor) {
        return valor <= this.getSaldo();
        //pode ter um débito de até $200;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return this.saldo + this.limite;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public static int getTotalDeContas() {
        return Conta.totalDeContas;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void transferir(double valor, Conta contaDestino) {
        if(temSaldo(valor)){
            this.saldo -= valor;
            contaDestino.saldo += valor;
        }
    }
}
