package LamdbaPractice.Example;

import java.util.ArrayList;
import java.util.function.Function;

public class GameData {
    ArrayList<Pitcher> pitcherList;
    ArrayList<Hitter> hitterList;
    Score score;
    GameCalculator cal;

    public GameData(Score score){
        pitcherList = new ArrayList<>();
        hitterList = new ArrayList<>();
        this.score = score;
        //cal = new GameCalculator();
    }

    public void addPitcher(Pitcher p){
        pitcherList.add(p);
    }

    public void addHitter(Hitter h){
        hitterList.add(h);
    }

}
