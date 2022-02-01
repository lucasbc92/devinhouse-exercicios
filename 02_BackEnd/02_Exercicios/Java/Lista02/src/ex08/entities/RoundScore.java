package ex08.entities;

import java.util.HashMap;
import java.util.Map;

public class RoundScore {
    public enum RoundStatus {
        HOME, AWAY, DRAW
    }

    private Map<Team, Integer> teamsScores;
    private Team homeTeam;
    private Team awayTeam;

    public RoundScore(){
        this.teamsScores = new HashMap<Team, Integer>();
        this.homeTeam = new Team("Home Team");
        this.awayTeam = new Team("Away Team");
        teamsScores.put(this.homeTeam, 0);
        teamsScores.put(this.awayTeam, 0);
    }

    public Team getHomeTeam(){
        return this.homeTeam;
    }

    public Team getAwayTeam(){
        return this.awayTeam;
    }

    public int getHomeScore(){
        return this.teamsScores.get(homeTeam);
    }

    public int getAwayScore(){
        return this.teamsScores.get(awayTeam);
    }

    public void addHomeScore(){
       this.teamsScores.put(homeTeam, teamsScores.get(homeTeam) + 1);
    }

    public void minusHomeScore(){
        this.teamsScores.put(homeTeam, teamsScores.get(homeTeam) - 1);       
    }

    public void addAwayScore(){
        this.teamsScores.put(awayTeam, teamsScores.get(awayTeam) + 1);
    }

    public void minusAwayScore(){
        this.teamsScores.put(awayTeam, teamsScores.get(awayTeam) - 1);      
    }

    public RoundStatus checkStatus(){
        int homeScore = this.getHomeScore();
        int awayScore = this.getAwayScore();
        if(homeScore > awayScore){
            return RoundStatus.HOME;
        } else if(awayScore > homeScore){
            return RoundStatus.AWAY;
        } else {
            return RoundStatus.DRAW;
        }
    }

    public String toString(){
        return String.format("%s %d X %d %s", this.homeTeam.getName(), this.getHomeScore(), this.getAwayScore(), this.awayTeam.getName());
    }
}
