package ex01.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonHealth {
    public enum Sex {
        MASCULINE("Masculine"), 
        FEMININE("Feminine");

        private String description;

        Sex(String description){
            this.description = description;
        }

        public String getDescription(){
            return this.description;
        }
    }

    private String name;
    private String lastName;
    private Sex sex;
    private LocalDate birthDate;
    private long age;
    private int heightCm;
    private double weightKg;

    public PersonHealth(String name, String lastName, Sex sex, LocalDate birthDate, int heightCm, double weightKg){
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        this.heightCm = heightCm;
        this.weightKg = weightKg;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFullName(){
        return this.name + " " + this.lastName;
    }

    public LocalDate getBirthDate(){
        return this.birthDate;
    }

     public long getAge(){
        return this.age;
    }

    public void doBirthday(){
        this.age++;
    }

    public Sex getSex(){
        return this.sex;
    }

    public int getHeight(){
        return this.heightCm;
    }

    public double getWeight(){
        return this.weightKg;
    }

    public void setHeight(int heightCm){
        this.heightCm = heightCm;
    }

    public void setWeight(double weightKg){
        this.weightKg = weightKg;
    }

    public String toString(){
        String pluralYear = "";
        if(this.getAge() > 1) {
            pluralYear = "s";
        }
        return String.format("Name: %s%nAge: %d year%s old%nBirthday: %s%nSex: %s%nHeight/Weight: %dcm/%.2fkg%n", 
            this.getFullName(),
            this.getAge(),
            pluralYear,
            this.getBirthDate(),
            this.sex.getDescription(),
            this.getHeight(),
            this.getWeight()
        );
    }
}
