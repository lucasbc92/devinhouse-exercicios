package ex01;

import ex01.entities.Person;

public class TestPerson {
    public static void main(String[] args) {
        Person maria = new Person("Maria", 0);
        Person john = new Person("John", 18);

        maria.doBirthday();
        john.doBirthday();

        System.out.println(maria);
        System.out.println(john);
    }
}
