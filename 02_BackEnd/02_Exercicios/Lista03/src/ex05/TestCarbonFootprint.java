package ex05;

import java.util.ArrayList;
import java.util.List;

import ex05.entities.Building;
import ex05.entities.Vehicle.Fuel;
import ex05.exceptions.IllegalFuelException;
import ex05.entities.Car;
import ex05.entities.Motorcycle;
import ex05.interfaces.CarbonFootprint;

public class TestCarbonFootprint {
    public static void main(String[] args) {
        List<CarbonFootprint> carbonFootprints = new ArrayList<CarbonFootprint>();
        carbonFootprints.add(new Building("Residencial Marajoara", 200000, 20000, 2000));
        carbonFootprints.add(new Car("Uno Mille", 1000, Fuel.ETHANOL));
        carbonFootprints.add(new Car("Chevrolet Onix", 1000, Fuel.GASOLINE));
        carbonFootprints.add(new Car("Volkswagen Gol", 1000, Fuel.CNG));
        carbonFootprints.add(new Car("Ford Montana", 1000, Fuel.DIESEL));
        try{
            carbonFootprints.add(new Motorcycle("Honda Fit", 1000, Fuel.ETHANOL));
            carbonFootprints.add(new Motorcycle("Yamaha Fazer", 1000, Fuel.GASOLINE));
            //carbonFootprints.add(new Motorcycle("Error Moto", 1000, Fuel.DIESEL));
            double totalKgCo2 = 0;
            for(CarbonFootprint carbonFootprint: carbonFootprints){
                double kgCo2 = carbonFootprint.getCarbonFootprint();
                totalKgCo2 += kgCo2;
                System.out.printf("%sCarbon footprint (kgs of CO2): %.2f%n%n", carbonFootprint.toString(), kgCo2);
            }
            System.out.printf("Total of kgs of C02: %.2f%n", totalKgCo2);
        } catch(IllegalFuelException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Leaving program...");  
    }
}
