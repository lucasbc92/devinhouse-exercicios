package ex04;

import java.util.NoSuchElementException;
import java.util.Scanner;

import ex04.entities.Address;
import ex04.entities.ContactsBook;
import ex04.entities.Email;
import ex04.entities.Person;
import ex04.entities.PhoneNumber;
import ex04.exceptions.InvalidEmailException;
import ex04.exceptions.InvalidPhoneNumberException;
import ex04.interfaces.Contact;

public class TestContactsBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ContactsBook contactsBook = new ContactsBook();
        int option = 0;
        do {
            System.out.println("Contacts Book");
            System.out.println("1 - Add Person");
            System.out.println("2 - Remove Person");
            System.out.println("3 - Search Person by Name");
            System.out.println("4 - Add Contact to Person");
            System.out.println("5 - Remove Contact from Person");
            System.out.println("6 - Print Book");
            System.out.println("0 - Exit");
            try{
                option = in.nextInt();
            } catch (NoSuchElementException e){
                System.out.println("Invalid option.");
                break;
            }            
            switch(option){
                case 0: break;
                case 1: {
                    in.nextLine();
                    System.out.print("First Name: ");
                    String name = in.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = in.nextLine();
                    Person person = new Person(name, lastName);
                    if(contactsBook.addPerson(person)){
                        System.out.printf("%s added into book!%n", person.getFullName());
                    } else {
                        System.out.println("Error: The book is full!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Which person do you want to remove?");
                    System.out.print(contactsBook.printPeopleNames());
                    System.out.println("0 - Go Back");
                    try{
                        int option2 = in.nextInt();
                        switch(option2){
                            case 0: break;
                            default: {
                                if(contactsBook.removePerson(option2 - 1)){
                                    System.out.println("Person removed from book!");
                                } else {
                                    System.out.println("Invalid option. No person was removed.");
                                }
                                break;
                            }
                        }                        
                    } catch (NoSuchElementException e) {
                        System.out.println("Invalid option. No person was removed.");
                        break;
                    }
                    break;                                      
                }
                case 3: {
                    in.nextLine();
                    System.out.print("First name: ");
                    String name = in.nextLine();
                    System.out.print("Last name: ");
                    String lastName = in.nextLine();
                    Person person = contactsBook.searchPerson(name, lastName);
                    if(person != null){
                        System.out.println(person);
                    } else {
                        System.out.println("Person not found in book.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Which person do you want to add a contact?");
                    System.out.print(contactsBook.printPeopleNames());
                    System.out.println("0 - Go Back");
                    try {
                        int option2 = in.nextInt();
                        switch(option2) {
                            case 0: break;
                            default: {
                                Person person = contactsBook.searchPerson(option2 - 1);
                                if(person != null){
                                    int option3 = 0;
                                    do {
                                        System.out.println("1 - Add an Address");
                                        System.out.println("2 - Add an Email");
                                        System.out.println("3 - Add a Phone Number");
                                        System.out.println("0 - Go Back");
                                        try {
                                            option3 = in.nextInt();
                                            switch(option3) {
                                                case 0: break;
                                                case 1: {
                                                    in.nextLine();
                                                    System.out.print("Address (without number): ");
                                                    String address = in.nextLine();
                                                    System.out.print("Address Number: ");
                                                    String addressNumber = in.nextLine();
                                                    System.out.print("City: ");
                                                    String city = in.nextLine();
                                                    System.out.print("State: ");
                                                    String state = in.nextLine();
                                                    System.out.print("Country: ");
                                                    String country = in.nextLine();
                                                    System.out.print("Complement (leave it empty if none): ");
                                                    String complement = in.nextLine();
                                                    Contact contact = new Address(address, addressNumber, city, state, country, complement);
                                                    person.addContact(contact);
                                                    System.out.println("Address added into person contacts.");
                                                    break;
                                                }
                                                case 2: {
                                                    in.nextLine();
                                                    System.out.print("Email: ");
                                                    String email = in.nextLine();
                                                    try {
                                                        Contact contact = new Email(email);
                                                        person.addContact(contact);
                                                        System.out.println("Email added into person contacts.");
                                                        break;
                                                    } catch (InvalidEmailException e) {
                                                        System.out.println("Invalid email.");
                                                        break;
                                                    }                                                 
                                                }
                                                case 3: {
                                                    in.nextLine();
                                                    System.out.print("Phone number (with country area +): ");
                                                    String phoneNumber = in.nextLine();
                                                    try {
                                                        Contact contact = new PhoneNumber(phoneNumber);
                                                        person.addContact(contact);
                                                        System.out.println("Phone number added into person contacts.");
                                                        break;
                                                    } catch (InvalidPhoneNumberException e) {
                                                        System.out.println("Invalid phone number.");
                                                        break;
                                                    }                                                    
                                                }
                                                default: {
                                                    System.out.println("Invalid option.");
                                                }
                                            }
                                        } catch (NoSuchElementException e) {
                                            System.out.println("Invalid option.");
                                            option3 = 1;
                                            continue;
                                        }
                                    } while(option3 != 0);
                                    break;
                                } else {
                                    System.out.println("Invalid option.");
                                    break;
                                }
                            }
                        }                        
                    } catch (NoSuchElementException e) {
                        System.out.println("Invalid option.");
                        break;
                    }
                    break;    
                }
                case 5: {
                    System.out.println("Which person do you want to remove a contact?");
                    System.out.print(contactsBook.printPeopleNames());
                    System.out.println("0 - Go Back");
                    try {
                        int option2 = in.nextInt();
                        switch(option2) {
                            case 0: break;
                            default: {
                                Person person = contactsBook.searchPerson(option2 - 1);
                                if(person != null){
                                    int option3 = 0;
                                    System.out.println("Which contact do you want to remove?");
                                    System.out.print(person.printContacts());
                                    System.out.println("0 - Exit");
                                    try {
                                        option3 = in.nextInt();
                                        switch(option3) {
                                            case 0: break;
                                            default: {
                                                if(person.removeContact(option3 - 1)){
                                                    System.out.println("Contact removed from book!");
                                                } else {
                                                    System.out.println("Invalid option. No contact was removed.");
                                                }
                                                break;
                                            }
                                        }
                                    } catch (NoSuchElementException e) {
                                        System.out.println("Invalid option.");
                                        break;
                                    }
                                } else {
                                    System.out.println("Invalid option.");
                                    break;
                                }
                            }
                        }                        
                    } catch (NoSuchElementException e) {
                        System.out.println("Invalid option.");
                        break;
                    }  
                    break;  
                }
                case 6: {
                    System.out.println(contactsBook);
                    break;
                }
                default: {
                    System.out.println("Invalid option.");
                }
            }
        } while(option != 0);
        System.out.println("Leaving program...");
    }
}
