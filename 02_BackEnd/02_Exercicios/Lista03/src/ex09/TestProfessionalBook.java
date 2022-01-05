package ex09;


import java.util.Scanner;

import ex09.entities.Contact;
import ex09.entities.ProfessionalBook;

public class TestProfessionalBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProfessionalBook book = new ProfessionalBook();
        int option = 0;
        do {
            System.out.println("1 - Add new contact");
            System.out.println("2 - List contacts");
            System.out.println("3 - Search contact by name");
            System.out.println("0 - Exit");
            option = in.nextInt();
            switch(option){
                case 0: break;
                case 1: {
                    in.nextLine();
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.print("Primary phone number: ");
                    String primaryPhoneNumber = in.nextLine();
                    System.out.print("Secondary phone number: ");
                    String secondaryPhoneNumber = in.nextLine();
                    System.out.print("Document id: ");
                    String docId = in.nextLine();
                    if(book.addContact(name, primaryPhoneNumber, secondaryPhoneNumber, docId)){
                        System.out.println("Contact added with success!");
                    } else {
                        System.out.println("Error: Invalid document id");
                    }
                    break;
                }
                case 2: System.out.println(book); break;
                case 3: {
                    in.nextLine();
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    Contact contactFound = book.searchByName(name);
                    if(contactFound == null){
                        System.out.println("Contact not found!");
                    } else {
                        System.out.println("Contact found!");
                        System.out.println(contactFound);
                    }
                }
            }
        } while(option != 0);
        System.out.println("Leaving program...");
    }
}
