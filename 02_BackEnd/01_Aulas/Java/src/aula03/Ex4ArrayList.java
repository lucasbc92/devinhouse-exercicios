package aula03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex4ArrayList {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();
        int qtNumbers = 5;

        for(int i = 0; i < qtNumbers; i++){
            System.out.printf("Digite o %sº número: ", i+1);
            numbers.add(keyboard.nextInt());
        }

        Collections.sort(numbers);

        System.out.println(numbers);

        numbers.forEach((number) -> {
            System.out.println(number);
        });

        keyboard.close();

    }
}
