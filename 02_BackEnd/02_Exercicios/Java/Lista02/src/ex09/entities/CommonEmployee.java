package ex09.entities;

public class CommonEmployee extends Employee {
    private final double INITIAL_BASE_SALARY = 1000;
    private final double INITIAL_INCREASE = 100;

    public CommonEmployee(){
        super();
        this.setBaseSalary(INITIAL_BASE_SALARY);
        this.setIncrease(INITIAL_INCREASE);
    }

    public double calculateSalary(int workedDays){
        return this.getBaseSalary() * ((double)workedDays/30) + this.getIncrease() * workedDays;
    }
}
