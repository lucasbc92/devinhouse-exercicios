package ex03;

import ex01.TestPerson;
import ex01.entities.PersonHealth;
import ex03.entities.HeartRate;

public class TestHeartRate {
    public static HeartRate[] createMariaAndJohnBPM(){
        PersonHealth[] mariaAndJohn = TestPerson.createMariaAndJohn();
        HeartRate mariaBPM = new HeartRate(mariaAndJohn[0]);
        HeartRate johnBPM = new HeartRate(mariaAndJohn[1]);
        HeartRate[] mariaAndJohnBPM = {mariaBPM, johnBPM};
        return mariaAndJohnBPM;
    }
    public static void main(String[] args) {
        HeartRate[] mariaAndJohnBPM = createMariaAndJohnBPM();

        System.out.println(mariaAndJohnBPM[0]);
        System.out.println(mariaAndJohnBPM[1]);
    }
}
