package ex09.entities;

import java.util.ArrayList;
import java.util.List;

import ex09.exceptions.InvalidDocumentIdException;

public class ProfessionalBook {
    private List<Contact> contacts;

    public ProfessionalBook(){
        this.contacts = new ArrayList<Contact>();
    }

    public List<Contact> getContacts(){
        return this.contacts;
    }

    public boolean addContact(String name, String primaryPhoneNumber, String secondaryPhoneNumber, String docId){
        try {
            contacts.add(new Person(name, primaryPhoneNumber, secondaryPhoneNumber, docId));
            return true;
        } catch (InvalidDocumentIdException e1) {
            try {
                contacts.add(new Enterprise(name, primaryPhoneNumber, secondaryPhoneNumber, docId));
                return true;
            }
            catch (InvalidDocumentIdException e2) {
                return false;
            }
        }
    }
    
    @Override
    public String toString(){
        String contactsStr = "";
        for(Contact contact: this.getContacts()){
            contactsStr += String.format("%s%n", contact.toString());
        }
        return contactsStr.equals("") ? String.format("The professional book is empty!%n") : contactsStr;
    }

    public Contact searchByName(String name){
        String nameLowerCase = name.toLowerCase();
        for(Contact contact: this.getContacts()){
            if(contact.getName().toLowerCase().equals(nameLowerCase)){
                return contact;
            }
        }
        return null;
    }
}
