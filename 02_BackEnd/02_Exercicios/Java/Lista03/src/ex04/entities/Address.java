package ex04.entities;

import ex04.interfaces.Contact;

public class Address implements Contact {
    private String address;
    private String addressNumber;
    private String city;
    private String state;
    private String country;
    private String complement;

    public Address(String address, String addressNumber, String city, String state, String country, String complement){
        this.address = address;
        this.addressNumber = addressNumber;
        this.city = city;
        this.state = state;
        this.country = country;
        this.complement = complement;
    }

    public String getAddress(){
        return this.address;
    }

    public String getAddressNumber(){
        return this.addressNumber;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public String getCountry(){
        return this.country;
    }

    public String getComplement(){
        return this.complement;
    }

    public String getContact(){
        String complementStr = this.getComplement();

        if(!complementStr.equals("")){
            complementStr = String.format("Complement: %s%n", complementStr);
        }
        return String.format("Address: %s, %s%n%s/%s, %s%n%s", this.getAddress(), this.getAddressNumber(), this.getCity(), this.getState(), this.getCountry(), complementStr);
    }
}
