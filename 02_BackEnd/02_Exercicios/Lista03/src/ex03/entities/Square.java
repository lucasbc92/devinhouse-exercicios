package ex03.entities;

import ex03.interfaces.AreaCalculable;

public class Square implements AreaCalculable {
    private double side;

    public Square(double side){
        this.side = side;
    }

    public double getSide(){
        return this.side;
    }

    public double calculateArea(){
        return Math.pow(this.getSide(), 2);
    }

    public String toString(){
        return String.format("Figure: Square%nSize: %.2f%nArea: %.2f%n", this.getSide(), this.calculateArea());
    }
}
