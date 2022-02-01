import java.time.LocalTime;
import java.util.Scanner;

public class Ex3Time {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Your first name: ");
        String name = in.nextLine(); 
        System.out.print("Your last name: ");
        String lastName = in.nextLine();
        System.out.printf("Hello %s %s, it is %s right now.", name, lastName, LocalTime.now().toString().substring(0,5));
        in.close();
    }
}
