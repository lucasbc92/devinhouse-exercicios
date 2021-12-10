package ex01.entities;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void doBirthday(){
        this.age++;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        String pluralYear = "";
        if(this.getAge() > 1) {
            pluralYear = "s";
        }
        return String.format("My name is %s and I'm %d year%s old.", this.getName(), this.getAge(), pluralYear);
    }
}
