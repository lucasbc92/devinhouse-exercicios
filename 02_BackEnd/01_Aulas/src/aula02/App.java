package aula02;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        double valor = 3.14;
        Locale ptBR = new Locale("pt", "BR");       
        System.out.printf(ptBR, "%5.1f%n", valor);
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(str);
        scan.close();
    }
}
