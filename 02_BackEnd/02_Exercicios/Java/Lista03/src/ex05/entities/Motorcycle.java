package ex05.entities;

import ex05.exceptions.IllegalFuelException;

public class Motorcycle extends Vehicle {
    private static final double ETHANOL_C02_PER_KM = 0.34;
    private static final double GASOLINE_C02_PER_KM = 0.68;

    public Motorcycle(String model, double kmPerMonth, Fuel fuel) throws IllegalFuelException{
        super(model, kmPerMonth, fuel);
        if(fuel != Fuel.ETHANOL && fuel != Fuel.GASOLINE){
            throw new IllegalFuelException(String.format("A motorcycle can't have %s as fuel", this.getFuel().name()));
        }        
    }

    public double getCarbonFootprint() throws IllegalFuelException {
        switch(this.getFuel()){
            case ETHANOL: return this.getKmPerMonth() * ETHANOL_C02_PER_KM;
            case GASOLINE: return this.getKmPerMonth() * GASOLINE_C02_PER_KM;
            default: throw new IllegalFuelException(String.format("A motorcycle can't have %s as fuel", this.getFuel().name()));
        }
    }
}
