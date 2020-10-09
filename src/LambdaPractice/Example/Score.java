package LambdaPractice.Example;

public class Score {
    int blueScore;
    int redScore;
    public Score(int team1, int team2){
        this.blueScore = team1;
        this.redScore = team2;
    }

    public int getTeam1() {
        return blueScore;
    }

    public void setTeam1(int team1) {
        this.blueScore = team1;
    }

    public int getTeam2() {
        return redScore;
    }

    public void setTeam2(int team2) {
        this.redScore = team2;
    }

    public void addBlueScore(){
        this.blueScore++;
    }

    public void addRedScore(){
        this.redScore++;
    }
}
