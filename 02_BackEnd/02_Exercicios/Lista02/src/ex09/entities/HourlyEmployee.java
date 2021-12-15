
package ex09.entities;

public class HourlyEmployee extends Employee {
    private final double INITIAL_BASE_SALARY = 1200;
    private final double INITIAL_INCREASE = 55;
    private final double INITIAL_DAILY_HOURS = 6;
    private double dailyHours;

    public HourlyEmployee(){
        super();
        this.setBaseSalary(INITIAL_BASE_SALARY);
        this.setIncrease(INITIAL_INCREASE);
        this.dailyHours = INITIAL_DAILY_HOURS;
    }

    public double calculateSalary(int workedDays){
        return this.getBaseSalary() * (workedDays/30) + this.getIncrease() * dailyHours * workedDays;
    }
}
