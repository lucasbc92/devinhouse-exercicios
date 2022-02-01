package ex05.interfaces;

import ex05.exceptions.IllegalFuelException;

public interface CarbonFootprint {
    public double getCarbonFootprint() throws IllegalFuelException;
}
