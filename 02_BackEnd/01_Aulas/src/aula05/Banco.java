package aula05;

public class Banco {
    public static void main(String[] args) {
        Conta minhaConta = new Conta("Lucas", "Bueno Cesario", 123, 1000000.99);
        Conta segundaConta = new Conta("Mauricio", "Sampaio", 999, 100);
        int totalDeContas = Conta.getTotalDeContas();
        // Cliente cliente1 = new Cliente();
        // Cliente cliente2 = new Cliente();

        // minhaConta.setCliente(cliente1);
        // segundaConta.setCliente(cliente2);

        minhaConta.sacar(100);
        minhaConta.depositar(50);
        minhaConta.transferir(100, segundaConta);

        System.out.println();
        System.out.printf("Total de contas: %d%n", totalDeContas);
        System.out.printf("O saldo atual do cliente %s %s é %.2f%n", minhaConta.getCliente().getNome(), minhaConta.getCliente().getSobrenome(), minhaConta.getSaldo());
        System.out.printf("O saldo atual do cliente %s %s é %.2f%n", segundaConta.getCliente().getNome(), segundaConta.getCliente().getSobrenome(), segundaConta.getSaldo());
    }
}
