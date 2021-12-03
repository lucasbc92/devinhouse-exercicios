
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex9SkateStreetBoard {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        float[] scores = new float[5];        
        float minScore = 11;
        float minScoreIndex = -1;        
        float maxScore = -1;
        float maxScoreIndex = -1;
        float averageConsideredScores = 0;
        for(int i = 0; i < scores.length; i++){
            System.out.printf("Informe score %d: ", (i+1));
            scores[i] = in.nextFloat();
            if(scores[i] < minScore){
                minScore = scores[i];
                minScoreIndex = i;
            }
            if(scores[i] > maxScore){
                maxScore = scores[i];
                maxScoreIndex = i;
            }
        }
        List<Float> consideredScores = new ArrayList<Float>();
        for(int i = 0; i < scores.length; i++){
            if(i == maxScoreIndex || i == minScoreIndex){
                continue;
            }
            consideredScores.add(scores[i]);
            averageConsideredScores += scores[i];
        }
        averageConsideredScores = (averageConsideredScores)/consideredScores.size();
        System.out.println("-------------------------------");
        System.out.printf("Average of the considered scores: %.2f%n", averageConsideredScores);
        System.out.printf("Maximum score: %.2f%n", maxScore);
        System.out.printf("Minimum score: %.2f%n", minScore);
        System.out.printf("Considered scores: %s%n", consideredScores);             
        in.close();
    }
}
