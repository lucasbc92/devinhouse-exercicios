package ex04.entities;

import java.util.regex.Pattern;

import ex04.exceptions.InvalidPhoneNumberException;
import ex04.interfaces.Contact;

public class PhoneNumber implements Contact {
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
        if(!Pattern.matches("\\+\\d+", phoneNumber)){
            throw new InvalidPhoneNumberException("The phone number is invalid.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getContact(){
        return String.format("Phone Number: %s%n", this.getPhoneNumber());
    }
}
