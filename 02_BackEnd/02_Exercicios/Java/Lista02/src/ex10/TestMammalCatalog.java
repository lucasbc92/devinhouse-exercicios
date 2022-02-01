package ex10;

import java.util.Scanner;

import ex10.entities.Bat;
import ex10.entities.Cat;
import ex10.entities.Dog;
import ex10.entities.MammalCatalog;

public class TestMammalCatalog {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MammalCatalog catalog = new MammalCatalog();
        System.out.println("Mammal Catalog");
        System.out.println("1: List Catalog");
        System.out.println("2: Account Catalog");
        System.out.println("3: Add Bat");
        System.out.println("4: Add Cat");
        System.out.println("5: Add Dog");
        System.out.println("0: Exit");
        int option = 0;
        do {
            option = in.nextInt();
            switch(option){
                case 0: break;
                case 1: System.out.println(catalog.list()); break;
                case 2: System.out.println(catalog.account()); break;
                case 3: catalog.addBat(new Bat()); System.out.println("Added a Bat..."); break;   
                case 4: catalog.addCat(new Cat()); System.out.println("Added a Cat..."); break; 
                case 5: catalog.addDog(new Dog()); System.out.println("Added a Dog..."); break;         
                default: System.out.println("Invalid option!");  
            }
        } while (option != 0);
        System.out.println("Leaving catalog...");
    }
}
