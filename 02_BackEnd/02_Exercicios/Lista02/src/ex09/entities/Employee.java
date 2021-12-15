package ex09.entities;

public abstract class Employee {
    private double baseSalary;
    private double increase;

    public Employee(){
    }

    public double getBaseSalary(){
        return this.baseSalary;
    }

    public double getIncrease(){
        return this.increase;
    }

    protected void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }

    protected void setIncrease(double increase){
        this.increase = increase;
    }

    public abstract double calculateSalary(int workedDays);
}
