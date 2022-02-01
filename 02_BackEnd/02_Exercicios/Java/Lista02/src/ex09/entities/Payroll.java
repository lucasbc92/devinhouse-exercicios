package ex09.entities;

import java.util.ArrayList;
import java.util.List;

public class Payroll {
    private List<Employee> employees;

    public Payroll(){
        this.employees = new ArrayList<Employee>();
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }

    public String listEmployees(){
        return this.getEmployees().toString();
    }

    public void addEmployee(Employee employee){
        this.getEmployees().add(employee);
    }

    public double getPayroll(int workedDays){
        double total = 0;
        for(Employee employee: employees){
            total += employee.calculateSalary(workedDays);
        }
        return total;
    }
}
