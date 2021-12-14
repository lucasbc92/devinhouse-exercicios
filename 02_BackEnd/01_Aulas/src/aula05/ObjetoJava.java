package aula05;

public class ObjetoJava {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        b = 20;
        System.out.printf("O Valor de 'a' é: %d%n", a);
        System.out.printf("O valor de 'b' é: %d%n", b);

        Conta c1 = new Conta(100);
        Conta c2 = c1;
        c2.depositar(200);

        //System.out.printf("O saldo de c1 é: %.2f%n", c1.saldo);
        //System.out.printf("O saldo de c2 é: %.2f%n", c2.saldo);
        
        System.out.println(c2.equals(c1));

        c2 = new Conta(100);
        c1.depositar(100);
        c2.depositar(100);
        
        System.out.println(c2.getSaldo() == c1.getSaldo());
    }
}
