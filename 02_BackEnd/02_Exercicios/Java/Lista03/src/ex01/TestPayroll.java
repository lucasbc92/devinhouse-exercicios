package ex01;

import java.util.Scanner;

import ex01.entities.Manager;
import ex01.entities.Assistant;
import ex01.entities.Seller;
import ex01.entities.Payroll;

public class TestPayroll {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Payroll payroll = new Payroll();
        System.out.println("Payroll");
        System.out.println("1: List Employees");
        System.out.println("2: Add Manager");
        System.out.println("3: Add Assistant");
        System.out.println("4: Add Seller");
        System.out.println("5: Get Payroll");
        System.out.println("0: Exit");
        int option = 0;
        do {
            option = in.nextInt();
            switch(option){
                case 0: break;
                case 1: {
                    System.out.println(payroll.listEmployees());
                    break;
                }
                case 2: {
                    in.nextLine();
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.print("Registration: ");
                    String registration = in.nextLine();
                    payroll.addEmployee(new Manager(name, registration));
                    System.out.println("Added a Manager...");
                    break;
                }
                case 3: {
                    in.nextLine();
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.print("Registration: ");
                    String registration = in.nextLine();
                    payroll.addEmployee(new Assistant(name, registration));
                    System.out.println("Added a Assistant...");
                    break;
                }
                case 4: {
                    in.nextLine();
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.print("Registration: ");
                    String registration = in.nextLine();
                    System.out.print("Commission: ");
                    double commission = in.nextDouble();
                    payroll.addEmployee(new Seller(name, registration, commission));
                    System.out.println("Added a Seller...");
                    break;
                }
                case 5: {
                    System.out.printf("Salaries%nTotal: $%.2f%n", payroll.getPayroll());
                    break;
                }       
                default: System.out.println("Invalid option!");     
            }
        } while (option != 0);
        System.out.println("Leaving payroll...");
    }
}

