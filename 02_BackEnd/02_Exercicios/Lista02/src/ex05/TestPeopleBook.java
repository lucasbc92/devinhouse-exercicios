package ex05;

import java.util.ArrayList;
import java.util.List;

import ex01.entities.PersonBook;
import ex05.entities.PeopleBook;

public class TestPeopleBook {
    public static List<PersonBook> createMariaAndJohn(){
        PersonBook maria = new PersonBook("Maria", 20, 160);
        PersonBook john = new PersonBook("John", 30, 180);
        List<PersonBook> mariaAndJohn = new ArrayList<PersonBook>();
        mariaAndJohn.add(maria);
        mariaAndJohn.add(john);
        return mariaAndJohn;
    }

    public static void addPerson(PeopleBook peopleBook, PersonBook person){
        if(peopleBook.addPerson(person)){
            System.out.printf("%s added into book.%n", person.getName());
        } else {
            System.out.printf("Error while adding %s into book: book is full.%n", person.getName());
        }
    }

    public static void removePerson(PeopleBook peopleBook, String name){
        if(peopleBook.removePerson(name)){
            System.out.printf("%s removed from book.%n", name);
        } else {
            System.out.printf("%s does not exist in the book.%n", name);
        }
    }
    public static void main(String[] args) throws Exception {
        List<PersonBook> mariaAndJohn = createMariaAndJohn();        
        PeopleBook peopleBook = new PeopleBook(mariaAndJohn);
        addPerson(peopleBook, new PersonBook("Lucas", 29, 172));
        addPerson(peopleBook, new PersonBook("Failure", 29, 172));
        PersonBook person = peopleBook.searchPerson("John");
        removePerson(peopleBook, person.getName());
        removePerson(peopleBook, "Failure");
        person = peopleBook.searchPerson("Failure");
        if(person == null){
            System.out.println("Failure does not exist in the book.");
        }
        System.out.println(peopleBook.printPerson(1));
        System.out.println(peopleBook.printPerson(2));
        System.out.println(peopleBook);
    }
}
