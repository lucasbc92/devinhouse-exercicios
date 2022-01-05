package ex05.entities;

import ex05.exceptions.IllegalFuelException;

public class Car extends Vehicle {
    private static final double ETHANOL_C02_PER_KM = 0.87;
    private static final double GASOLINE_C02_PER_KM = 1.74;
    private static final double CNG_C02_PER_KM = 1.65;
    private static final double DIESEL_C02_PER_KM = 2.82;

    public Car(String model, double kmPerMonth, Fuel fuel){
        super(model, kmPerMonth, fuel);
    }

    public double getCarbonFootprint() throws IllegalFuelException{
        switch(this.getFuel()){
            case ETHANOL: return this.getKmPerMonth() * ETHANOL_C02_PER_KM;
            case GASOLINE: return this.getKmPerMonth() * GASOLINE_C02_PER_KM;
            case CNG: return this.getKmPerMonth() * CNG_C02_PER_KM;
            case DIESEL: return this.getKmPerMonth() * DIESEL_C02_PER_KM;
            default: throw new IllegalFuelException("Unknown fuel type");
        }
    }
}
