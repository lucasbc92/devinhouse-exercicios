import java.util.Scanner;
//import java.util.regex.Pattern;

public class Ex8Jokenpo {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("--- JOKENPO ---");
        String moves = "Example";
        int playerAWins = 0;
        int playerBWins = 0;
        loop:
        while(true){
            System.out.print("Inform the moves: ");
            moves = in.nextLine();
            //if(Pattern.matches("([RPS] [RPS])?", moves)){
            //     System.out.println("Invalid moves.");
            //     continue;
            // }
            switch(moves){
                case "": break loop;
                case "R R": break;
                case "P P": break;
                case "S S": break;
                case "R S": {
                    playerAWins++;
                    break;
                }
                case "P R": {
                    playerAWins++;
                    break;
                }
                case "S P": {
                    playerAWins++;
                    break;
                }
                case "S R": {
                    playerBWins++;
                    break;
                }
                case "R P": {
                    playerBWins++;
                    break;
                }
                case "P S": {
                    playerBWins++;
                    break;
                }
                default: {
                    System.out.println("Invalid moves.");
                }
            }            
        }
        System.out.println("-----------------------------");
        System.out.printf("Player A    %d x %d    Player B", playerAWins, playerBWins);
        in.close();
    }
}
