import java.util.Scanner;

import ex01.TestPayroll;
import ex02.TestWebCard;
import ex03.TestAreaCalculation;
import ex04.TestContactsBook;
import ex05.TestCarbonFootprint;
import ex06.TestAuthUser;
import ex08.TestRealEstateSystem;
import ex09.TestProfessionalBook;
import ex10.TestThriftStoreSystem;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("What exercise do you want to execute? Press '0' to exit.");
            System.out.println("1 - Payroll");
            System.out.println("2 - Web Card");
            System.out.println("3 - Area Calculation");
            System.out.println("4 - Contacts Book");
            System.out.println("5 - Carbon Footprint");
            System.out.println("6 - User Authentication");
            System.out.println("7 - User Authentication");
            System.out.println("8 - Real Estate System");
            System.out.println("9 - Professional Book");
            System.out.println("10 - Thrift Store System");  
            option = in.nextInt();

            switch(option){
                case 0: break;
                case 1: {
                    TestPayroll.main(null);
                    break;
                }
                case 2: {
                    TestWebCard.main(null);
                    break;
                }
                case 3: {
                    TestAreaCalculation.main(null);
                    break;
                }
                case 4: {
                    TestContactsBook.main(null);
                    break;
                }
                case 5: {
                    TestCarbonFootprint.main(null);
                    break;
                }
                case 6: {
                    TestAuthUser.main(null);
                    break;
                }
                case 7: {
                    TestAuthUser.main(null);
                }
                case 8: {
                    TestRealEstateSystem.main(null);
                    break;
                }
                case 9: {
                    TestProfessionalBook.main(null);
                    break;
                }
                case 10: {
                    TestThriftStoreSystem.main(null);
                    break;
                }
                default: System.out.println("Invalid option!");
            }
        } while(option != 0);
        System.out.println("Leaving program...");
        in.close();
    }
}
