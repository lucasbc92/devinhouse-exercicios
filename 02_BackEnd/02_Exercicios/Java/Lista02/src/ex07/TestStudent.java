package ex07;

import ex07.entities.SpecialStudent;
import ex07.entities.Student;

public class TestStudent {
    public static void main(String[] args) {
        try{
            Student student = new Student("17989", 50);
            Student specialStudent = new SpecialStudent("18993", 20);
            System.out.println(student);
            System.out.println(specialStudent);
        } catch (Exception e){
            System.out.println(e.getMessage());            
        }        
    }
}
