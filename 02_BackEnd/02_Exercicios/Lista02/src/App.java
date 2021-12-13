import java.util.Scanner;

import ex01.TestPerson;
import ex02.TestInvoice;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("What exercise do you want to execute? Press '0' to exit.");
            System.out.println("1 - Person");
            System.out.println("2 - Computer Shop");
            System.out.println("3 - Person");
            System.out.println("4 - Person");
            System.out.println("5 - Person");
            System.out.println("6 - Person");
            System.out.println("7 - Person");
            System.out.println("8 - Person");
            System.out.println("9 - Person");
            System.out.println("10 - Person");  
            option = in.nextInt();

            switch(option){
                case 0: break;
                case 1: {
                    TestPerson.main(null);
                    break;
                }
                case 2: {
                    TestInvoice.main(null);
                    break;
                }
                case 3: {
                    TestPerson.main(null);
                    break;
                }
                case 4: {
                    TestPerson.main(null);
                    break;
                }
                case 5: {
                    TestPerson.main(null);
                    break;
                }
                case 6: {
                    TestPerson.main(null);
                    break;
                }
                case 7: {
                    TestPerson.main(null);
                    break;
                }
                case 8: {
                    TestPerson.main(null);
                    break;
                }
                case 9: {
                    TestPerson.main(null);
                    break;
                }
                case 10: {
                    TestPerson.main(null);
                    break;
                }
                default: System.out.println("Invalid option!");
            }
        } while(option != 0);
        System.out.println("Leaving program...");
        in.close();
    }
}
