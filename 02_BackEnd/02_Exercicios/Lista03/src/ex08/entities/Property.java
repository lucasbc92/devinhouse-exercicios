package ex08.entities;

import ex04.entities.Address;

public abstract class Property {
    private Address address;
    private int roomsNumber;
    private String description;
    private int sqm;
    private double purchasePrice;
    private double rentalPrice;
    private double propertyTax;

    public Property(Address address, int roomsNumber, String description, int sqm, double purchasePrice, double rentalPrice, double propertyTax){
        this.address = address;
        this.roomsNumber = roomsNumber;
        this.description = description;
        this.sqm = sqm;
        this.purchasePrice = purchasePrice;
        this.rentalPrice = rentalPrice;
        this.propertyTax = propertyTax;
    }

    public Address getAddress(){
        return this.address;
    }

    public int getRoomsNumber(){
        return this.roomsNumber;
    }

    public String getDescription(){
        return this.description;
    }

    public int getSqm(){
        return this.sqm;
    }

    public double getPurchasePrice(){
        return this.purchasePrice;
    }

    public double getRentalPrice(){
        return this.rentalPrice;
    }

    public double getPropertyTax(){
        return this.propertyTax;
    }

    public abstract double getMaintenancePrice();

    @Override
    public String toString(){
        return String.format(
            "Property type: %s%nPurchase price: %.2f%nRental Price: %.2f%nMaintenance Price: %.2f%n",
            this.getClass().getSimpleName(),
            this.getPurchasePrice(),
            this.getRentalPrice(),
            this.getMaintenancePrice()
        );
    }
}
