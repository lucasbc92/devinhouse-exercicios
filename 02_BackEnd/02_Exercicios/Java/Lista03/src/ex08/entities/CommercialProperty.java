package ex08.entities;

import ex04.entities.Address;

public class CommercialProperty extends Property {
    private final double SQM_PERCENTUAL_INCREASE = 0.02;
    private final int SQM_EVERY = 100;
    private final int SQM_FLOOR = 1000;
    private double licensePrice;

    public CommercialProperty(Address address, int roomsNumber, String description, int sqm, double purchasePrice, double rentalPrice, double propertyTax, double licensePrice){
        super(address, roomsNumber, description, sqm, purchasePrice, rentalPrice, propertyTax);
        this.licensePrice = licensePrice;
    }

    public double getLicensePrice(){
        return this.licensePrice;
    }

    @Override
    public double getPurchasePrice(){
        double percentualIncrease = SQM_PERCENTUAL_INCREASE * Math.floor((this.getSqm() - SQM_FLOOR)/SQM_EVERY);
        percentualIncrease = percentualIncrease < 0 ? 0 : percentualIncrease;
        return super.getPurchasePrice() + super.getPurchasePrice() * percentualIncrease;
    }

    @Override
    public double getMaintenancePrice(){
        return this.getPropertyTax() + this.getLicensePrice();
    }
}
