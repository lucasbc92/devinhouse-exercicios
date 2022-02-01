package ex03;

import java.util.Scanner;

import ex03.entities.Rectangle;
import ex03.entities.Square;
import ex03.entities.Triangle;
import ex03.interfaces.AreaCalculable;

public class TestAreaCalculation{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Area Calculation");
        System.out.println("Create one of the following figures to know its area:");
        System.out.println("1: Square");
        System.out.println("2: Rectangle");
        System.out.println("3: Triangle");
        System.out.println("0: Exit");
        int option = 0;
        do {
            option = in.nextInt();
            switch(option){
                case 0: break;
                case 1: {
                    System.out.print("Side size: ");
                    double side = in.nextDouble();
                    AreaCalculable square = new Square(side);
                    System.out.println(square);
                    break;
                }
                case 2: {
                    System.out.print("Width: ");
                    double width = in.nextDouble();
                    System.out.print("Height: ");
                    double height = in.nextDouble();
                    AreaCalculable rectangle = new Rectangle(width, height);
                    System.out.println(rectangle);
                    break;
                }
                case 3: {
                    System.out.print("Width: ");
                    double width = in.nextDouble();
                    System.out.print("Height: ");
                    double height = in.nextDouble();
                    AreaCalculable triangle = new Triangle(width, height);
                    System.out.println(triangle);
                    break;
                }
                default: System.out.println("Invalid option!");     
            }
        } while (option != 0);
        System.out.println("Leaving program...");
    }
}
