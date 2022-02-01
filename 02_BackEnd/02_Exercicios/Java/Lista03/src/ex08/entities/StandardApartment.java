package ex08.entities;

import ex04.entities.Address;

public class StandardApartment extends Property {
    private double condoPrice;

    public StandardApartment(Address address, int roomsNumber, String description, int sqm, double purchasePrice, double rentalPrice, double propertyTax, double condoPrice){
        super(address, roomsNumber, description, sqm, purchasePrice, rentalPrice, propertyTax);
        this.condoPrice = condoPrice;
    }

    public double getCondoPrice(){
        return this.condoPrice;
    }

    @Override
    public double getMaintenancePrice(){
        return this.getPropertyTax() + this.getCondoPrice();
    }
}
