package ex09;

import java.util.Scanner;

import ex09.entities.CivilEmployee;
import ex09.entities.CommonEmployee;
import ex09.entities.HourlyEmployee;
import ex09.entities.Payroll;

public class TestPayroll {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Payroll payroll = new Payroll();
        System.out.println("Payroll");
        System.out.println("1: List Employees");
        System.out.println("2: Add Common Employee");
        System.out.println("3: Add Hourly Employee");
        System.out.println("4: Add Civil Employee");
        System.out.println("5: Get Payroll (10 days)");
        System.out.println("6: Get Payroll (21 days)");
        System.out.println("7: Get Payroll (30 days)");
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
                    payroll.addEmployee(new CommonEmployee());
                    System.out.println("Added a Common Employee...");
                    break;
                }
                case 3: {
                    payroll.addEmployee(new HourlyEmployee());
                    System.out.println("Added a Hourly Employee...");
                    break;
                }
                case 4: {
                    payroll.addEmployee(new CivilEmployee());
                    System.out.println("Added a Civil Employee...");
                    break;
                }
                case 5: {
                    System.out.printf("Salaries (10 days)%nTotal: $%.2f%n", payroll.getPayroll(10));
                    break;
                }       
                case 6: {
                    System.out.printf("Salaries (21 days)%nTotal: $%.2f%n", payroll.getPayroll(21));
                    break;
                }
                case 7: {
                    System.out.printf("Salaries (30 days)%nTotal: $%.2f%n", payroll.getPayroll(30));
                    break;
                }
                default: System.out.println("Invalid option!");     
            }
        } while (option != 0);
        System.out.println("Leaving payroll...");
    }
}
