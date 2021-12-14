package ex08;

import java.util.Scanner;

import ex08.entities.RoundScore;
import ex08.entities.RoundScore.RoundStatus;

public class TestRoundScore {

    public static void checkStatus(RoundScore roundScore){
        RoundStatus roundStatus = roundScore.checkStatus();
        switch(roundStatus){
            case HOME: System.out.println("Home Team is winning!"); break;
            case AWAY: System.out.println("Away Team is winning!"); break;
            case DRAW: System.out.println("The round is tied!"); break;
        }
    }

    public static void checkWinner(RoundScore roundScore){
        RoundStatus roundStatus = roundScore.checkStatus();
        switch(roundStatus){
            case HOME: System.out.println("Home Team won!"); break;
            case AWAY: System.out.println("Away Team won!"); break;
            case DRAW: System.out.println("The round ended up in a tie!"); break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RoundScore roundScore = null;
        int option = 0;
        System.out.println("Welcome to the Round Score");
        System.out.println("1: Start new round");
        System.out.println("2: Check current score");
        System.out.println("3: + Point Home Team");
        System.out.println("4: - Point Home Team");
        System.out.println("5: + Point Away Team");
        System.out.println("6: - Point Away Team");
        System.out.println("7: Finish round");
        System.err.println("0: Exit");
        do {
            option = in.nextInt();
            switch(option){
                case 0: {
                    if(roundScore != null){
                        System.out.println("You can't leave the program without finishing the round!");
                        option = 1;
                        break;
                    }
                    break;
                }
                case 1: {
                    if(roundScore == null){
                        roundScore = new RoundScore();
                        System.out.println("New game initialized");
                        System.out.println(roundScore);
                        break;
                    } else {
                        System.out.println("You can't start a new round without finishing the current one!");
                        break;
                    }
                }
                case 2: {
                    if(roundScore == null) {
                        System.out.println("You didn't start a round yet!");
                        break;
                    }
                    System.out.println(roundScore);
                    checkStatus(roundScore);
                    break;
                }
                case 3: {
                    if(roundScore == null) {
                        System.out.println("You didn't start a round yet!");
                        break;
                    }
                    roundScore.addHomeScore();
                    System.out.println(roundScore);
                    break;
                }
                case 4: {
                    if(roundScore == null) {
                        System.out.println("You didn't start a round yet!");
                        break;
                    }
                    roundScore.minusHomeScore();
                    System.out.println(roundScore);
                    break;
                }
                case 5: {
                    if(roundScore == null) {
                        System.out.println("You didn't start a round yet!");
                        break;
                    }
                    roundScore.addAwayScore();
                    System.out.println(roundScore);
                    break;
                }
                case 6: {
                    if(roundScore == null) {
                        System.out.println("You didn't start a round yet!");
                        break;
                    }
                    roundScore.minusAwayScore();
                    System.out.println(roundScore);
                    break;
                }
                case 7: {
                    if(roundScore == null) {
                        System.out.println("You didn't start a round yet!");
                        break;
                    }
                    checkWinner(roundScore);
                    roundScore = null;
                    do {
                        System.out.println("Start a new round? 1 - Yes, 0 - No");
                        option = in.nextInt();
                        switch(option){
                            case 0: break;
                            case 1: {
                                roundScore = new RoundScore();
                                System.out.println("New game initialized");
                                System.out.println(roundScore);
                                break;
                            }
                            default: System.out.println("Invalid option.");
                        }
                    } while(option != 0 && option != 1);   
                    break;                 
                }
                default: System.out.println("Invalid option.");
            }
        } while(option != 0);
        System.out.println("Until next time...");
        in.close();
    }
}
