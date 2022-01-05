package ex01.entities;

public class Manager extends Employee{
    public Manager(String name, String registration){
        super(name, registration);        
    }

    public double calculateSalary(){
        return this.getBaseSalary() * 2;
    }
}
