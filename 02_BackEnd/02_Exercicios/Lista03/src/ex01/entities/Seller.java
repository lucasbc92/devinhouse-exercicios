package ex01.entities;

public class Seller extends Employee {
    private double commission;

    public Seller(String name, String description, double commission){
        super(name, description);
        this.commission = commission;
    }

    public double getCommission(){
        return this.commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double calculateSalary(){
        return this.getBaseSalary() + this.getCommission();
    }

    public String toString(){
        return super.toString() + String.format("Commission: %.2f%n", this.getCommission());
    }
}
