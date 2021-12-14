package ex05.entities;

import java.util.ArrayList;
import java.util.List;

import ex01.entities.PersonBook;

public class PeopleBook {
    private final int MAX_PEOPLE = 3;
    private List<PersonBook> people;

    public PeopleBook(){
        people = new ArrayList<PersonBook>();
    }

   public PeopleBook(List<PersonBook> people) throws Exception{
        this();
        if(people.size() > MAX_PEOPLE){
            // System.out.printf("The number of people in the list excedes the maximum permitted by the book (%d people).%nTaking the %d first people of the list into the book...", 
            // this.MAX_PEOPLE, 
            // this.MAX_PEOPLE
            //);
            throw new Exception("The number of people in the list excedes the maximum permitted by the book (" + MAX_PEOPLE +")");        
        }
        this.people = people;
    }

    public int getMaxPeople(){
        return this.MAX_PEOPLE;
    }

    public List<PersonBook> getPeople(){
        return this.people;
    }

    public boolean addPerson(PersonBook person){
        if(this.people.size() == MAX_PEOPLE){
            return false;
        }
        people.add(person);
        return true;        
    }

    public boolean removePerson(String name){
        for(PersonBook person: people){
            if(person.getName() == name) {
                people.remove(person);
                return true;
            }
        }
        return false;
    }

    public PersonBook searchPerson(String name){
        for(PersonBook person: people){
            if(person.getName() == name) {
                return person;
            }
        }
        return null;
    }

    public String printPerson(int index){
        if(index >= this.people.size()){
            return null;
        }
        return people.get(index).toString();
    }

    public String toString(){
        String personBookStr = "";
        for(int i = 0; i < this.people.size(); i++){
            personBookStr += String.format("Person %d:%n%s%n", (i+1), printPerson(i));
        }
        return personBookStr;
    }
}
