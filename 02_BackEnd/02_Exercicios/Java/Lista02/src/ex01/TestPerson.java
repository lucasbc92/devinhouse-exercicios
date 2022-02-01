package ex01;

import java.time.LocalDate;

import ex01.entities.PersonHealth;
import ex01.entities.PersonHealth.Sex;

public class TestPerson {
    public static PersonHealth[] createMariaAndJohn(){
        PersonHealth maria = new PersonHealth("Maria", "Silva", Sex.FEMININE, LocalDate.of(2021, 12, 1), 48, 3);
        PersonHealth john = new PersonHealth("John", "Smith", Sex.MASCULINE, LocalDate.of(2000, 1, 1), 180, 99.5);
        PersonHealth[] mariaAndJohn = {maria, john};
        return mariaAndJohn;
    }
    public static void main(String[] args) {
        PersonHealth[] mariaAndJohn = TestPerson.createMariaAndJohn();

        mariaAndJohn[0].doBirthday();
        mariaAndJohn[1].doBirthday();

        System.out.println(mariaAndJohn[0]);
        System.out.println(mariaAndJohn[1]);
    }
}
