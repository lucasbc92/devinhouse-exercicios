import java.util.Scanner;

public class Ex7Health {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Your sex (Type m for Masculine, f for Feminine): ");
        String sex = in.nextLine();
        if(!(sex.equals("m") || sex.equals("f"))){
            System.out.println("Error: wrong input. Aborting execution...");
            in.close();
            return;
        }
        System.out.print("How much weight do you want to lose in a month? (kg): ");
        float kgLostInMonth = in.nextFloat();
        if(kgLostInMonth > 3) {
            System.out.println("Losing more than 3 kg per month can be harmful.");
            in.close();
            return;
        }
        System.out.print("Your weight (kg): ");
        float weight = in.nextFloat();
        System.out.print("Your height (cm): ");
        int height = in.nextInt();
        System.out.print("Your age (years): ");
        int age = in.nextInt();
        // System.out.print("Hours spent doing physical exercise (hours/day): ");
        // float timeExercisePerDay = in.nextFloat(); 
        double kcalAbstainedToLoseWeight = kgLostInMonth*7000;
        double[] kcalIngestedPerDay = new double[3];
        int kcalConstant = 0;
        if(sex == "m"){
            kcalConstant = 5;
        } else {
            kcalConstant = -161;
        }
        for(int i = 0; i < 3; i++){
            kcalIngestedPerDay[i] = 10*weight + 6.25*height + 5*age + 400*(i+1) + kcalConstant;
            double kcalIngestedPerMonth = kcalIngestedPerDay[i]*30;
            double kcalDay = (kcalIngestedPerMonth-kcalAbstainedToLoseWeight)/30;
            System.out.printf("You need a diet of: %.2f kcal/day if you spend %d hours doing physical exercise.%n", kcalDay, (i+1));
        }
        in.close();
    }
}
