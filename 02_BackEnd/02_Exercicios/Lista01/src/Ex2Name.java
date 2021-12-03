import java.util.Scanner;

public class Ex2Name {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Your first name: ");
        String name = in.nextLine(); 
        System.out.print("Your last name: ");
        String lastName = in.nextLine();
        System.out.printf("Your full name is: %s %s", name, lastName);
        in.close();
    }
}
