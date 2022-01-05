package ex01.entities;

public abstract class Employee {
    private String name;
    private String registration;
    private double baseSalary;
    private final double BASE_SALARY = 1000;

    public Employee(String name, String registration){
        this.name = name;
        this.registration = registration;
        this.baseSalary = BASE_SALARY;
    }

    public String getName(){
        return this.name;
    }

    public String getRegistration(){
        return this.registration;
    }

    public double getBaseSalary(){
        return this.baseSalary;
    }

    public abstract double calculateSalary();

    public String toString(){
        return String.format("Name: %s%nRegistration: %s%nRole: %s%nSalary: %.2f%n", this.getName(), this.getRegistration(), this.getClass().getSimpleName(), this.calculateSalary());
    }

}
