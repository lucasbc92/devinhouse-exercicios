package ex01.entities;

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
        if(this.getEmployees().isEmpty()){
            return String.format("The list is empty!%n");
        }
        String list = "";
        for(Employee employee : this.getEmployees()){
            list += employee.toString();
        }
        return list;
    }

    public void addEmployee(Employee employee){
        this.getEmployees().add(employee);
    }

    public double getPayroll(){
        double total = 0;
        for(Employee employee: employees){
            total += employee.calculateSalary();
        }
        return total;
    }
}
