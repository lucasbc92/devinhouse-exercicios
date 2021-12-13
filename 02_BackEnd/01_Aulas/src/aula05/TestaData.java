package aula05;

import java.util.Scanner;

public class TestaData {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o dia da data: ");
        int diaDigitado = entrada.nextInt();

        System.out.print("Digite o mês da data: ");
        int mesDigitado = entrada.nextInt();

        System.out.print("Digite o ano da data: ");
        int anoDigitado = entrada.nextInt();

        Data data = new Data();

        data.dia = diaDigitado;
        data.mes = mesDigitado;
        data.ano = anoDigitado;

        System.out.println(data.exibirData());

        entrada.close();
    }
}
