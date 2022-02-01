package ex04.entities;

import java.util.ArrayList;
import java.util.List;

public class ContactsBook {
    private List<Person> people;
    private final int BOOK_LIMIT = 10;

    public ContactsBook(){
        this.people = new ArrayList<Person>();
    }

    public List<Person> getPeople(){
        return this.people;
    }

    public Person searchPerson(String name, String lastName){
        Person person = new Person(name, lastName);
        String fullName = person.getFullName();
        for(int i = 0; i < this.getPeople().size(); i++){
            Person personFromList = this.getPeople().get(i);
            if(personFromList.getFullName().equals(fullName)){
                return personFromList;
            }
        }
        return null;
    }

    public Person searchPerson(int index){
        try {
            Person person = this.getPeople().get(index);
            return person;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean addPerson(Person person){
        if(this.getPeople().size() == BOOK_LIMIT){
            return false;
        }
        this.people.add(person);
        return true;
    }

    public boolean removePerson(int index){
        try {
            this.getPeople().remove(index);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public String printPeopleNames(){
        String peopleNames = "";
        for(int i = 0; i < this.getPeople().size(); i++){
            peopleNames += String.format("%d - %s%n", (i+1), this.getPeople().get(i).getFullName());
        }
        return peopleNames != "" ? peopleNames : String.format("The contacts book is empty!%n");
    }

    @Override
    public String toString(){
        String peopleStr = "";
        for(int i = 0; i < this.getPeople().size(); i++){
            peopleStr += String.format("%d - %s%n", (i+1), this.getPeople().get(i).toString());
        }
        return peopleStr != "" ? peopleStr : String.format("The contacts book is empty!%n");
    }
}
