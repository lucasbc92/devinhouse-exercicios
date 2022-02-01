package ex01.entities;
 
public class Assistant extends Employee{
    public Assistant(String name, String registration){
        super(name, registration);        
    }

    public double calculateSalary(){
        return this.getBaseSalary();
    }
}
