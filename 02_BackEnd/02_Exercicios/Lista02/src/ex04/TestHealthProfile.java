package ex04;

import java.time.LocalDate;
import java.util.Scanner;

import ex01.entities.PersonHealth;
import ex01.entities.PersonHealth.Sex;
import ex03.TestHeartRate;
import ex03.entities.HeartRate;
import ex04.entities.HealthProfile;

public class TestHealthProfile {
    public static HealthProfile[] createMariaAndJohnHealthProfiles(){
        HeartRate[] mariaAndJohnBPM = TestHeartRate.createMariaAndJohnBPM();
        HealthProfile mariaHealthProfile = new HealthProfile(mariaAndJohnBPM[0]);
        HealthProfile johnHealthProfile = new HealthProfile(mariaAndJohnBPM[1]);
        HealthProfile[] mariaAndJohnHealthProfiles = {mariaHealthProfile, johnHealthProfile};
        return mariaAndJohnHealthProfiles;
    }

    public static Sex getSex(Scanner in){
        String sexStr = "";
        while(!(sexStr.equals("m") || sexStr.equals("f"))){
            System.out.print("Your sex ('m' for masculine, 'f' for feminine): ");
            sexStr = in.next();
        }
        return sexStr.equals("m") ? Sex.MASCULINE : Sex.FEMININE;
    }

    public static LocalDate getBirthDate(Scanner in){
        try {
            System.out.print("Your birth year: ");
            int year = in.nextInt();
            System.out.print("Your birth month (from 1 to 12): ");
            int month = in.nextInt();
            System.out.print("Your birth day of month (from 1 to 31): ");
            int day = in.nextInt(); 
            return LocalDate.of(year, month, day);   
        } catch(Exception e) {
            System.out.println("Invalid date. Please, insert it again.");
            return getBirthDate(in);
        }
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 0;
        do {
            System.out.print("Your first name: ");
            String name = in.nextLine();
            System.out.print("Your last name: ");
            String lastName = in.nextLine();
            Sex sex = getSex(in);
            LocalDate birthDate = getBirthDate(in); 
            System.out.print("Your height (cm): ");
            int height = in.nextInt();
            System.out.print("Your weight (kg): ");
            double weight = in.nextDouble();
            System.out.println("");
            PersonHealth person = new PersonHealth(name, lastName, sex, birthDate, height, weight);
            HeartRate personBPM = new HeartRate(person);
            HealthProfile personHealthProfile = new HealthProfile(personBPM);
            System.out.println(personHealthProfile);
            System.out.println("Do you want to create another health profile? Press any number other than 0 to continue; press 0 to exit. ");
            option = in.nextInt();
        } while(option != 0);
        System.out.println("Leaving program...");
        //in.close();
    }
}
