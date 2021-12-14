package aula07;

import aula07.entidades.Conta;
import aula07.entidades.ContaCorrente;
import aula07.entidades.ContaPoupanca;

public class AppBanco {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("9876", 100);
        ContaPoupanca cp = new ContaPoupanca("1234", 200);
        
        System.out.println(cc);
        System.out.println(cp);

        cp.transferir(100, cc);
        cc.sacar(50);
        cp.depositar(150);

        System.out.println(cc);
        System.out.println(cp);

        System.out.println(Conta.bonus());
        System.out.println(ContaPoupanca.bonus());
    }
}
