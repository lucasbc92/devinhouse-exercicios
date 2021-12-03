import java.util.Scanner;

public class Ex1RandomNumber {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int exit = 1;
        while(true){
            System.out.println("Should I generate a random number? 0 - No, 1 - Yes");
            exit = in.nextInt();
            if(exit == 0){
                System.out.println("Leaving...");
                in.close();
                break;
            }
            if(exit == 1) {
                System.out.printf("%2f%n", Math.random());
            }            
        }        
    }
}
