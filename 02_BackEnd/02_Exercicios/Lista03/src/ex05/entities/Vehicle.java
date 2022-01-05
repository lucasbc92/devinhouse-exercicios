package ex05.entities;

import ex05.exceptions.IllegalFuelException;
import ex05.interfaces.CarbonFootprint;

public abstract class Vehicle implements CarbonFootprint {


    public enum Fuel {
        // ETHANOL(ETHANOL_C02_PER_KM),
        // GASOLINE(GASOLINE_C02_PER_KM),
        // CNG(CNG_C02_PER_KM),
        // DIESEL(DIESEL_C02_PER_KM);

        // private double co2PerKm;

        // Fuel(double co2PerKm){
        //     this.co2PerKm = co2PerKm;
        // }

        // public double getCo2PerKm(){
        //     return co2PerKm;
        // }
        ETHANOL, GASOLINE, CNG, DIESEL;
    }

    private String model;
    private double kmPerMonth;
    private Fuel fuel;

    public Vehicle(String model, double kmPerMonth, Fuel fuel){
        this.model = model;
        this.kmPerMonth = kmPerMonth;
        this.fuel = fuel;
    }

    public String getModel(){
        return this.model;
    }

    public double getKmPerMonth(){
        return this.kmPerMonth;
    }

    public Fuel getFuel(){
        return this.fuel;
    }

    public String toString(){
        return String.format("Model: %s%nKM/month: %.2f%nFuel: %s%n", this.getModel(), this.getKmPerMonth(), this.getFuel().name());
    }

    public abstract double getCarbonFootprint() throws IllegalFuelException;
}
