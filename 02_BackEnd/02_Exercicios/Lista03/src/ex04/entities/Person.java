package ex04.entities;

import java.util.ArrayList;
import java.util.List;

import ex04.interfaces.Contact;

public class Person {
    private List<Contact> contacts;
    private String name;
    private String lastName;

    public Person(String name, String lastName){
        this.contacts = new ArrayList<Contact>();
        this.name = name;
        this.lastName = lastName;
    }

    public Person(List<Contact> contacts, String name, String lastName){
        this.contacts = contacts;
        this.name = name;
        this.lastName = lastName;
    }

    public List<Contact> getContacts(){
        return this.contacts;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getFullName(){
        return this.name + " " + this.lastName;
    }

    public void addContact(Contact contact){
        this.getContacts().add(contact);
    }

    public boolean removeContact(Contact contact){
        // String contactStr = contact.getContact();
        // for(Contact contactFromList: contacts){
        //     if(contactFromList.getContact().equals(contactStr)){
        //         this.getContacts().remove(contactFromList);
        //         return true;
        //     }
        // }
        // return false;
        return this.getContacts().remove(contact);
    }

    public boolean removeContact(int index){
        try {
            this.getContacts().remove(index);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public String printContacts(){
        String contactsStr = "";
        for(int i = 0; i < this.getContacts().size(); i++){
            contactsStr += String.format("%d - %s", (i+1), this.getContacts().get(i).getContact());
        }
        return contactsStr != "" ? contactsStr : String.format("The contacts list is empty!%n");
    }

    @Override
    public String toString(){        
        return String.format("Name: %s %s%n%s", this.getName(), this.getLastName(), this.printContacts());
    }
}
