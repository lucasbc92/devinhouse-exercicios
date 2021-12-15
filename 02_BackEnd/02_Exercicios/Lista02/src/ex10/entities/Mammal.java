package ex10.entities;

public abstract class Mammal {
    public Mammal(){
        
    }

    public String introduce(){
        return String.format("I'm a %s!", this.getClass().getSimpleName());
    }
}
