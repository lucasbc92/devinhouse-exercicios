/*
Exercício: Escreva um programa para ler duas notas de um aluno. Calcule e imprima a média do semestre. O programa deve aceitar apenas pontuações válidas, notas entre 0 e 10. Cada pontuação deve ser validada separadamente.
O programa deve imprimir uma mensagem "Novo cálculo (1 - sim 2 - não)". Depois, a entrada será (1 ou 2). 3, 2 significa que a execução deve ser concluída.

Entrada:
O programa deve começar solicitando um número inteiro X, após do número X duas entradas

Saída:
Se uma pontuação inválida for lida, deve ser impressa a mensagem "Nota inválida". 
Quando duas pontuações válidas são lidas, a mensagem "Média = [valor da média]" deve ser impressa. A mensagem "Novo cálculo (1 - sim 2 - não)" deve ser impressa após a leitura de X. Essa mensagem deve ser exibida novamente se o número de entrada padrão para X for menor que 1 ou maior que 2.
*/

package aula02;

import java.util.Scanner;

public class CalculoDeNotas {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Novo cálculo (1 - sim 2 - não)");
        float nota1 = 0;
        float nota2 = 0;
        float media = 0;
        int opcao = entrada.nextInt();
        while(opcao != 2){
            if(opcao == 1){
                System.out.printf("Digite a primeira nota: ");
                nota1 = entrada.nextFloat();
                if(nota1 < 0 || nota1 > 10) {
                    System.out.println("Nota inválida");
                    continue;
                }
                System.out.printf("Digite a segunda nota: ");
                nota2 = entrada.nextFloat();
                if(nota2 < 0 || nota2 > 10) {
                    System.out.println("Nota inválida");
                    continue;
                }
                media = (nota1 + nota2)/2;
                System.out.printf("Média: %.2f%n", media);
            } else {
                System.out.printf("Opção inválida. Digite uma opção válida.\n");
            }           
            System.out.println("Novo cálculo (1 - sim 2 - não)");
            opcao = entrada.nextInt();
        }
        entrada.close();
    }
}
