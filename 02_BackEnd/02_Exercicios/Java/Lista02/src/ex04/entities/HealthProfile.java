package ex04.entities;

import ex03.entities.HeartRate;

public class HealthProfile {
    private HeartRate personBPM;

    public HealthProfile(HeartRate personBPM){
        this.personBPM = personBPM;
    }

    public HeartRate getPersonBPM(){
        return this.personBPM;
    }

    public double getBMI(){
        return this.personBPM.getPerson().getWeight() / Math.pow(((double)this.personBPM.getPerson().getHeight()/100), 2);
    }

    public String toString(){  
        double bmi = this.getBMI();
        String status = "Normal";
        if(bmi < 18.5){
            status = "Underweight";
        } else if(bmi > 25 && bmi <= 30){
            status = "Overweight";
        } else if(bmi > 30){
            status = "Obesity";
        }
        return String.format("%sBMI: %.1f (%s)%n", this.getPersonBPM(), bmi, status);
    }
}
