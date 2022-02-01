package ex09.entities;

public class CivilEmployee extends Employee {
    private final double INITIAL_BASE_SALARY = 1500;
    private final double INITIAL_INCREASE_PERCENTAGE = 0.05;
    private final double INITIAL_INCREASE = INITIAL_INCREASE_PERCENTAGE;
    private final double INITIAL_PERCENTAGE_LIMIT = 0.65;
    private double percentageLimit;


    public CivilEmployee(){
        super();
        this.setBaseSalary(INITIAL_BASE_SALARY);
        this.setIncrease(INITIAL_INCREASE);
        this.percentageLimit = INITIAL_PERCENTAGE_LIMIT;
    }

    public double calculateSalary(int workedDays){
        double salaryIncreasePercentage = this.getIncrease() * workedDays;
        
        if(salaryIncreasePercentage > percentageLimit){
            salaryIncreasePercentage = percentageLimit;
        }
        return this.getBaseSalary() * ((double)workedDays/30) + this.getBaseSalary() * salaryIncreasePercentage;
    }
}
