import java.util.Scanner;

public class Ex10RoundBest {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int[] playersVotes = new int[11];
        int totalVotes = 0;
        int chosenPlayer = -1;
        do {
            System.out.print("Vote in a player (1 ~ 11): ");
            try {
                chosenPlayer = in.nextInt();
                if(chosenPlayer < 0 || chosenPlayer > 11) {
                    System.out.println("Invalid value.");
                    continue;
                }
                playersVotes[chosenPlayer-1]++;
                totalVotes++;
            } catch (Exception e) {
                System.out.println("Invalid value.");
                in.nextLine();
                continue;
            }
        } while(chosenPlayer != 0);
        if(totalVotes > 0) {
            System.out.println("Player N:\tVotes\tPercentage");
            System.out.println("--------------------------------------");
            int roundBestVotes = 0;
            int roundBestNumber = -1;
            for(int i = 0; i < playersVotes.length; i++){
                if(playersVotes[i] != 0) {
                    float percentage = (float)playersVotes[i]*100/totalVotes;
                    System.out.printf("Player %d\t%d\t%.2f%%%n", (i+1), playersVotes[i], percentage);
                    if(playersVotes[i] > roundBestVotes){
                        roundBestVotes = playersVotes[i];
                        roundBestNumber = i+1;
                    }
                }
            }
            System.out.printf("Player %d is the round best!", roundBestNumber);   
        }            
        in.close();   
    }
}
