import java.util.Scanner;

import ex01.TestPerson;
import ex03.TestHeartRate;
import ex04.TestHealthProfile;
import ex05.TestPeopleBook;
import ex06.TestLanguage;
import ex07.TestStudent;
import ex08.TestRoundScore;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("What exercise do you want to execute? Press '0' to exit.");
            System.out.println("1 - Person");
            System.out.println("2 - Computer Shop");
            System.out.println("3 - Heart Rate");
            System.out.println("4 - Health Profile");
            System.out.println("5 - People Book");
            System.out.println("6 - Languages");
            System.out.println("7 - Students");
            System.out.println("8 - Round Score");
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
                    TestPerson.main(null);
                    break;
                }
                case 3: {
                    TestHeartRate.main(null);
                    break;
                }
                case 4: {
                    TestHealthProfile.main(null);
                    break;
                }
                case 5: {
                    TestPeopleBook.main(null);
                    break;
                }
                case 6: {
                    TestLanguage.main(null);
                    break;
                }
                case 7: {
                    TestStudent.main(null);
                    break;
                }
                case 8: {
                    TestRoundScore.main(null);
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
