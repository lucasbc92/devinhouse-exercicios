package ex05.entities;

import ex05.interfaces.CarbonFootprint;

public class Building implements CarbonFootprint {
    private static final double CONCRETE_CO2_PER_KG = 0.10;
    private static final double STEEL_C02_PER_KG = 1.85;
    private static final double ALUMINIUM_C02_PER_KG = 11.5;

    private String name;
    private double kgsConcrete;
    private double kgsSteel;
    private double kgsAluminium;

    public Building(String name, double kgsConcrete, double kgsSteel, double kgsAluminium){
        this.name = name;
        this.kgsConcrete = kgsConcrete;
        this.kgsSteel = kgsSteel;
        this.kgsAluminium = kgsAluminium;
    }

    public String getName(){
        return this.name;
    }

    public double getTonsConcrete(){
        return this.kgsConcrete;
    }

    public double getTonsSteel(){
        return this.kgsSteel;
    }

    public double getTonsAluminium(){
        return this.kgsAluminium;
    }

    public String toString(){
        return String.format("Name: %s%n", this.getName());
    }

    public double getCarbonFootprint(){
        return this.getTonsConcrete()*CONCRETE_CO2_PER_KG + this.getTonsSteel()*STEEL_C02_PER_KG + this.getTonsAluminium()*ALUMINIUM_C02_PER_KG;
    }
}
