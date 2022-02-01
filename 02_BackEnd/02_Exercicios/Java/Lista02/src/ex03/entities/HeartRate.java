package ex03.entities;

import ex01.entities.PersonHealth;

public class HeartRate {
    private PersonHealth person;

    public HeartRate(PersonHealth person){
        this.person = person;
    }

    public PersonHealth getPerson(){
        return this.person;
    }

    public long getMaxBPM(){
        return 220 - this.getPerson().getAge();
    }

    public long[] getTargetBPM(){
        long[] targetBPM = new long[2];
        targetBPM[0] = this.getMaxBPM()*50/100;
        targetBPM[1] = this.getMaxBPM()*85/100;
        return targetBPM;
    }
    
    public String toString(){
        long[] targetBPM = this.getTargetBPM();
        return String.format("%sMaximum Heart Rate: %d BPM%nTarget heart rate: %d BPM - %d BPM%n", this.getPerson(), this.getMaxBPM(), targetBPM[0], targetBPM[1]);
    }
}


