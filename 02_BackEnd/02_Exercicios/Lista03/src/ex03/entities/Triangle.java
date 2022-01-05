package ex03.entities;

import ex03.interfaces.AreaCalculable;

public class Triangle implements AreaCalculable {
    private double width;
    private double height;

    public Triangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    public double calculateArea(){
        return (width * height) / 2;
    }

    public String toString(){
        return String.format("Figure: Triangle%nWidth: %.2f%nHeight: %.2f%nArea: %.2f%n", this.getWidth(), this.getHeight(), this.calculateArea());
    }
}
