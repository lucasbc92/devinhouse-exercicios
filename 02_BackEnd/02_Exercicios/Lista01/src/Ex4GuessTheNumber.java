import java.util.Scanner;

public class Ex4GuessTheNumber {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int nTries = 1;
        int min = 1;
        int max = 5;
        int option = 0;
        do {
            int chosenNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
            int myNumber = 0;
            while(true) {
                System.out.printf("Guess the chosen number from %d to %d: ", min, max);
                myNumber = in.nextInt();
                if(myNumber < min || myNumber > max){
                    System.out.println("Invalid number.");
                } else {
                    break;
                }
            }
            if(myNumber == chosenNumber){
                System.out.printf("Congratulations, you guessed it in %d tries!%n", nTries);
                nTries = 1;                
            } else {
                System.out.printf("Wrong answer, the chosen number was %d.%n", chosenNumber);
                nTries++;
            }
            System.out.println("Do you want to try again? Type 0 to exit.");
            option = in.nextInt();
        }
        while(option != 0);
        in.close();
    }
}
