import java.util.Scanner;

public class Ex6EthanolOrGasoline {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Ethanol price ($/L)");
        float ethPrice = in.nextFloat();
        System.out.println("Gasoline price ($/L)");
        float gasPrice = in.nextFloat();
        System.out.println("Car efficiency on Ethanol (km/L)");
        float ethEfficiency = in.nextFloat();
        System.out.println("Car efficiency on Gasoline (km/L)");
        float gasEfficiency = in.nextFloat();
        System.out.println("Average car run (km)");
        float avgCarRun = in.nextFloat();
        float ethAvgCost = (avgCarRun * ethPrice)/ethEfficiency;
        float gasAvgCost = (avgCarRun * gasPrice)/gasEfficiency;
        String chosenFuel = ethAvgCost <= gasAvgCost ? "Ethanol" : "Gasoline";
        System.out.printf("Ethanol average cost: $%.2f%n", ethAvgCost);
        System.out.printf("Gasoline average cost: $%.2f%n", gasAvgCost);
        System.out.printf("%s is a more cost-efficient fuel for your car.%n", chosenFuel);
        in.close();
    }
}
