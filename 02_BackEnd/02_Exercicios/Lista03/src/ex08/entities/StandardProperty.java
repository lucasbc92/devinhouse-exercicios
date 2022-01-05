package ex08.entities;

import ex04.entities.Address;

public class StandardProperty extends Property {

    public StandardProperty(Address address, int roomsNumber, String description, int sqm, double purchasePrice, double rentalPrice, double propertyTax){
        super(address, roomsNumber, description, sqm, purchasePrice, rentalPrice, propertyTax);
    }

    public double getMaintenancePrice(){
        return this.getPropertyTax();
    }
}
